package com.example.demo.serviceImpl.apply;

import com.example.demo.Util.DateUtil;
import com.example.demo.dao.ApplyTicketServiceDAO;
import com.example.demo.dao.RoomServiceDAO;
import com.example.demo.dao.UserServiceDAO;
import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.RoomUseDO;
import com.example.demo.entity.UserDO;
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

    @Override
    public BaseResponse<QueryApplyTicketResponse> queryAllApplyTickets(int pageIndex, int pageSize) {
        List<ApplyTicketDO> applyTicketDOS = applyTicketServiceDAO.queryAll(pageIndex, pageSize);
        QueryApplyTicketResponse response = new QueryApplyTicketResponse();
        response.setItems(transformApplyTicket(applyTicketDOS));
        response.setTotal(applyTicketServiceDAO.queryAllCount());
        return BaseResponse.returnSuccessData(response);
    }

    @Override
    public BaseResponse<Boolean> dealApplication(DealApplicationRequest request) {
        ApplyTicketDO applyTicketDO = new ApplyTicketDO();
        applyTicketDO.setStatus(Integer.valueOf(request.getStatus()));
        applyTicketDO.setId(request.getApplicationId());
        UserDO userDO = userServiceDAO.queryUserByName(request.getOperatorName());
        if (userDO == null || userDO.getType() != 1) {
            return BaseResponse.returnFailData("400", "用户验证失败，请重新登录");
        }
        applyTicketDO.setProcessorid(userDO.getUserid());
        applyTicketDO.setProcessorname(userDO.getUsername());
        if (request.getStatus().equals("2") && request.getReason() != null && !request.getReason().isEmpty()) {
            applyTicketDO.setRefusereason(request.getReason());
        }
        applyTicketDO.setAddresstime(new Date());
        return BaseResponse.returnSuccessData(applyTicketServiceDAO.update(applyTicketDO));
    }

    @Override
    public BaseResponse<Boolean> doApply(ApplyRequest request) {

        try {
            if (checkConflict(request.getStart(), request.getEnd(), request.getRoomId())) {
                return BaseResponse.returnSuccessData(false);
            }
            if (request.getApplicant() == null || request.getApplicant().isEmpty()) {
                return BaseResponse.returnSuccessData(false);
            }
            UserDO userDO = userServiceDAO.queryUserByName(request.getApplicant());
            if (userDO == null || userDO.getType() != 0) {
                return BaseResponse.returnSuccessData(false);
            }
            ApplyTicketDO applyTicketDO = new ApplyTicketDO();
            applyTicketDO.setApplicant(userDO.getUsername());
            applyTicketDO.setApplicantid(userDO.getUserid());
            applyTicketDO.setStatus(0);
            applyTicketDO.setCreatetime(new Date());
            applyTicketDO.setStarttime(request.getStart());
            applyTicketDO.setEndtime(request.getEnd());
            applyTicketDO.setRoomid(request.getRoomId());
            applyTicketDO.setRoomname(request.getRoom());
            applyTicketDO.setApplyreason(request.getApplyReason());
            applyTicketServiceDAO.insertApplyTicket(applyTicketDO);
            return BaseResponse.returnSuccessData(true);
        } catch (Exception e) {
            logger.error("do apply error", e);
            return BaseResponse.returnFailData(ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMessage());
        }
    }

    private List<ApplyTicket> transformApplyTicket(List<ApplyTicketDO> applyTicketDOS) {
        List<ApplyTicket> applyTickets = new ArrayList<>();
        for (ApplyTicketDO applyTicketDO : applyTicketDOS) {
            ApplyTicket applyTicket = new ApplyTicket();
            applyTicket.setApplyReason(applyTicketDO.getApplyreason());
            applyTicket.setId(applyTicketDO.getId());
            applyTicket.setApplicantName(applyTicketDO.getApplicant());
            applyTicket.setCreateTime(DateUtil.parseDate(applyTicketDO.getCreatetime()));
            applyTicket.setRoomName(applyTicketDO.getRoomname());
            applyTicket.setStartTime(DateUtil.parseDate(applyTicketDO.getStarttime()));
            applyTicket.setEndTime(DateUtil.parseDate(applyTicketDO.getEndtime()));
            switch (applyTicketDO.getStatus()) {
                case 0: applyTicket.setStatus("待处理");
                break;
                case 1: applyTicket.setStatus("已同意");
                break;
                case 2: applyTicket.setStatus("已拒绝");
                break;
            }
            applyTicket.setProcessorName(applyTicketDO.getProcessorname());
            applyTicket.setRefuseReason(applyTicketDO.getRefusereason());
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
