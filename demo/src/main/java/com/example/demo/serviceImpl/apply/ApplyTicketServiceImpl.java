package com.example.demo.serviceImpl.apply;

import com.example.demo.dao.ApplyTicketServiceDAO;
import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.client.ApplyTicket;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.service.apply.ApplyTicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyTicketServiceImpl implements ApplyTicketService {

    @Resource
    ApplyTicketServiceDAO applyTicketServiceDAO;

    @Override
    public BaseResponse<List<ApplyTicketDO>> queryAllApplyTickets(QueryApplyTicketRequest request) {
        List<ApplyTicketDO> applyTicketDOS = applyTicketServiceDAO.queryAll(request.getPageIndex(), request.pageSize);
        return BaseResponse.returnSuccessData(applyTicketDOS);
    }

    private List<ApplyTicket> transformApplyTicket(List<ApplyTicketDO> applyTicketDOS) {
        List<ApplyTicket> applyTickets = new ArrayList<>();
        for (ApplyTicketDO applyTicketDO : applyTicketDOS) {
            ApplyTicket applyTicket = new ApplyTicket();
            applyTicket.setApplyReason(applyTicketDO.getApplyreason());
            applyTicket.setId(applyTicketDO.getId());
            applyTicket.setApplicantName(applyTicketDO.getApplicant());
            applyTicket.setCreateTime(applyTicketDO.getCreatetime());
            applyTicket.setRoomName(applyTicketDO.getRoomname());
            applyTicket.setStartTime(applyTicketDO.getStarttime());
            applyTicket.setEndTime(applyTicketDO.getEndtime());
            switch (applyTicketDO.getStatus()) {
                case 0: applyTicket.setStatus("待处理");
                break;
                case 1: applyTicket.setStatus("同意");
                break;
                case 2: applyTicket.setStatus("拒绝");
                break;
            }
            applyTicket.setProcessorName(applyTicketDO.getProcessorname());
            applyTicket.setRefuseReason(applyTicketDO.getRefusereason());
            applyTickets.add(applyTicket);
        }
        return applyTickets;
    }
}
