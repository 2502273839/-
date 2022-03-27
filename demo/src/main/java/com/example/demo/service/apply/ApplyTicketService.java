package com.example.demo.service.apply;

import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;

import java.util.List;

public interface ApplyTicketService {
    public BaseResponse<List<ApplyTicketDO>> queryAllApplyTickets(QueryApplyTicketRequest request);
}
