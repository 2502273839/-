package com.example.demo.serviceImpl.apply;

import com.example.demo.Util.DateUtil;
import com.example.demo.dao.ApplyTicketServiceDAO;
import com.example.demo.dao.UserServiceDAO;
import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.UserDO;
import com.example.demo.entity.client.ApplyTicket;
import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryApplyTicketResponse;
import com.example.demo.service.apply.ApplyTicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplyTicketServiceImpl implements ApplyTicketService {

    @Resource
    ApplyTicketServiceDAO applyTicketServiceDAO;

    @Resource
    UserServiceDAO userServiceDAO;

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
}
