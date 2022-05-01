package com.example.demo.serviceImpl.apply;

import com.example.demo.Util.DateUtil;
import com.example.demo.Util.Switch;
import com.example.demo.dao.ApplyTicketServiceDAO;
import com.example.demo.dao.RoomServiceDAO;
import com.example.demo.dao.UserDataServiceDAO;
import com.example.demo.dao.UserServiceDAO;
import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.RoomUseDO;
import com.example.demo.entity.UserDO;
import com.example.demo.entity.UserDataDO;
import com.example.demo.entity.client.ApplyTicket;
import com.example.demo.model.ErrorCode;
import com.example.demo.model.request.ApplyRequest;
import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryApplyTicketResponse;
import com.example.demo.service.apply.ApplyTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplyTicketServiceImpl implements ApplyTicketService {
    private static final Logger logger = LoggerFactory.getLogger(ApplyTicketServiceImpl.class);

    @Resource
    ApplyTicketServiceDAO applyTicketServiceDAO;

    @Resource
    UserServiceDAO userServiceDAO;

    @Resource
    RoomServiceDAO roomServiceDAO;

    @Resource
    UserDataServiceDAO userDataServiceDAO;

    @Override
    public BaseResponse<QueryApplyTicketResponse> queryAllApplyTickets(QueryApplyTicketRequest request) {
        List<ApplyTicketDO> applyTicketDOS;
        if (request.pageIndex == -1) {
            applyTicketDOS = applyTicketServiceDAO.queryAll(request);
        } else {
            applyTicketDOS = applyTicketServiceDAO.queryAllByPage(request);
        }
        QueryApplyTicketResponse response = new QueryApplyTicketResponse();
        response.setItems(transformApplyTicket(applyTicketDOS));
        response.setTotal(applyTicketServiceDAO.queryAllCount(request));
        return BaseResponse.returnSuccessData(response);
    }

    @Override
    public BaseResponse<Boolean> dealApplication(DealApplicationRequest request) {
        try {
            ApplyTicketDO applyTicketDO = applyTicketServiceDAO.queryById(request.getApplicationId());
            applyTicketDO.setStatus(Integer.valueOf(request.getStatus()));
            UserDO userDO = userServiceDAO.queryUserByName(request.getOperatorName());
            if (userDO == null || userDO.getType() != 1) {
                return BaseResponse.returnFailData(ErrorCode.USER_FAIL_AUTH.getCode(), ErrorCode.USER_FAIL_AUTH.getMessage());
            }
            applyTicketDO.setProcessorId(userDO.getUserid());
            applyTicketDO.setProcessorName(userDO.getUsername());
            if (request.getStatus().equals("1")) {
                addRoomUse(applyTicketDO);
            } else if (request.getStatus().equals("4")) {
                addUserData(applyTicketDO);
            }
            applyTicketDO.setAddressTime(new Date());
            boolean update = applyTicketServiceDAO.update(applyTicketDO);
            return BaseResponse.returnSuccessData(update);
        } catch (Exception e) {
            logger.error("dealApplication error", e);
            return BaseResponse.returnFailData(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMessage());
        }

    }

    @Override
    public BaseResponse<Boolean> doApply(ApplyRequest request) {
        try {
            String day = DateUtil.parseDateByDay(request.getDay());
            Date start = DateUtil.formatDayAndHour(day, request.getStart());
            Date end = DateUtil.formatDayAndHour(day, request.getEnd());
            if (checkConflict(start, end, request.getRoomId())) {
                return BaseResponse.returnSuccessData(false);
            }
            if (request.getApplicant() == null || request.getApplicant().isEmpty()) {
                return BaseResponse.returnSuccessData(false);
            }
            UserDO userDO = userServiceDAO.queryUserByName(request.getApplicant());
            if (userDO == null) {
                return BaseResponse.returnSuccessData(false);
            }
            ApplyTicketDO applyTicketDO = new ApplyTicketDO();
            applyTicketDO.setApplicant(userDO.getUsername());
            applyTicketDO.setApplicantId(userDO.getUserid());
            applyTicketDO.setStatus(0);
            applyTicketDO.setCreateTime(new Date());
            applyTicketDO.setStartTime(start);
            applyTicketDO.setEndTime(end);
            applyTicketDO.setRoomId(request.getRoomId());
            applyTicketDO.setRoomName(request.getRoom());
            applyTicketDO.setLesson(request.getLesson());
            applyTicketDO.setContent(request.getContent());
            applyTicketDO.setTeacher(request.getTeacher());
            applyTicketDO.setClassHour(request.getClassHour());
            if (Switch.openAutoProcess) {
                dealApplyAuto(applyTicketDO);
            } else {
                applyTicketServiceDAO.insertApplyTicket(applyTicketDO);
            }
            return BaseResponse.returnSuccessData(true);
        } catch (Exception e) {
            logger.error("do apply error", e);
            return BaseResponse.returnFailData(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMessage());
        }
    }

    /**
     * 自动处理申请，默认通过
     * @param applyTicketDO
     */
    public void dealApplyAuto(ApplyTicketDO applyTicketDO) {
        applyTicketDO.setProcessorName("系统处理");
        applyTicketDO.setProcessorId(0);
        applyTicketDO.setStatus(1);
        applyTicketDO.setAddressTime(new Date());
        applyTicketServiceDAO.insertApplyTicketSelective(applyTicketDO);
        addRoomUse(applyTicketDO);
    }

    public void addRoomUse(ApplyTicketDO applyTicketDO) {
        RoomUseDO roomUseDO = new RoomUseDO();
        roomUseDO.setApplyTicketId(applyTicketDO.getApplicantId());
        roomUseDO.setRoomid(applyTicketDO.getRoomId());
        roomUseDO.setDay(DateUtil.parseDateByDay(applyTicketDO.getStartTime()));
        roomUseDO.setStart(applyTicketDO.getStartTime());
        roomUseDO.setEnd(applyTicketDO.getEndTime());
        roomServiceDAO.insertRoomUse(roomUseDO);
    }

    public void addUserData(ApplyTicketDO applyTicketDO) {
        String teacher = applyTicketDO.getTeacher();
        UserDO userDO = userServiceDAO.queryUserByName(teacher);
        if (userDO != null) {
            UserDataDO userData = userDataServiceDAO.getUserDataByUserId(userDO.getUserid());
            if (userData == null) {
                userData = new UserDataDO();
                userData.setUserid(userDO.getUserid());
                userData.setApplyNum(0);
                userData.setClassHour(String.valueOf(0));
            }
            userData.setApplyNum(userData.getApplyNum() + 1);
            userData.setClassHour(String.valueOf(Integer.valueOf(userData.getClassHour()) + Integer.valueOf(applyTicketDO.getClassHour())));
            userDataServiceDAO.insertUserData(userData);
        }
    }

    @Override
    public BaseResponse<QueryApplyTicketResponse> queryApplyTicketsByApplicant(int pageIndex, int pageSize, String applicant) {
        List<ApplyTicketDO> applyTicketDOS = applyTicketServiceDAO.queryAllByName(pageIndex, pageSize, applicant);
        QueryApplyTicketResponse response = new QueryApplyTicketResponse();
        response.setItems(transformApplyTicket(applyTicketDOS));
        response.setTotal(applyTicketServiceDAO.queryCountByName(applicant));
        return BaseResponse.returnSuccessData(response);
    }

    @Override
    public BaseResponse<Boolean> cancelApply(DealApplicationRequest request) {

        UserDO userDO = userServiceDAO.queryUserByName(request.getOperatorName());
        if (userDO == null || userDO.getType() != 0) {
            return BaseResponse.returnFailData("400", "用户验证失败，请重新登录");
        }
        ApplyTicketDO applyTicketDO = applyTicketServiceDAO.queryById(request.getApplicationId());
        if (applyTicketDO == null || applyTicketDO.getStatus() != 0 || !request.getStatus().equals("3")) {
            return BaseResponse.returnFailData("401", "撤销失败，申请单非待处理状态");
        }
        applyTicketDO.setStatus(Integer.valueOf(request.getStatus()));
        applyTicketDO.setModifiedTime(new Date());
        return BaseResponse.returnSuccessData(applyTicketServiceDAO.update(applyTicketDO));
    }

    private List<ApplyTicket> transformApplyTicket(List<ApplyTicketDO> applyTicketDOS) {
        List<ApplyTicket> applyTickets = new ArrayList<>();
        for (ApplyTicketDO applyTicketDO : applyTicketDOS) {
            ApplyTicket applyTicket = new ApplyTicket();
            applyTicket.setId(applyTicketDO.getId());
            applyTicket.setApplicantName(applyTicketDO.getApplicant());
            applyTicket.setCreateTime(DateUtil.parseDate(applyTicketDO.getCreateTime()));
            applyTicket.setRoomName(applyTicketDO.getRoomName());
            applyTicket.setStartTime(DateUtil.parseDate(applyTicketDO.getStartTime()));
            applyTicket.setEndTime(DateUtil.parseDate(applyTicketDO.getEndTime()));
            switch (applyTicketDO.getStatus()) {
                case 0: applyTicket.setStatus("待处理");
                break;
                case 1: applyTicket.setStatus("已同意");
                break;
                case 2: applyTicket.setStatus("已拒绝");
                break;
                case 3: applyTicket.setStatus("已撤销");
                break;
                case 4: applyTicket.setStatus("已确认");
            }
            applyTicket.setContent(applyTicketDO.getContent());
            applyTicket.setClassHour(applyTicketDO.getClassHour());
            applyTicket.setLesson(applyTicketDO.getLesson());
            applyTicket.setTeacher(applyTicketDO.getTeacher());
            applyTickets.add(applyTicket);
        }
        return applyTickets;
    }

    public boolean checkConflict(Date start, Date end, Integer roomId) {
        List<RoomUseDO> roomUseDOS = roomServiceDAO.queryRoomUseById(roomId);
        String day = DateUtil.parseDateByDay(start);
        for (RoomUseDO roomUseDO : roomUseDOS) {
            if (roomUseDO.getDay().equals(day)) {
                if (!(start.after(roomUseDO.getEnd()) || end.before(roomUseDO.getStart()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
