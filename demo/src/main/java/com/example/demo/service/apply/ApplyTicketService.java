package com.example.demo.service.apply;


import com.example.demo.model.request.ApplyRequest;
import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryApplyTicketResponse;

import java.util.List;

public interface ApplyTicketService {
    public BaseResponse<QueryApplyTicketResponse> queryAllApplyTickets(QueryApplyTicketRequest request);

    public BaseResponse<Boolean> dealApplication(DealApplicationRequest request);

    public BaseResponse<Boolean> doApply(ApplyRequest request);

    public BaseResponse<QueryApplyTicketResponse> queryApplyTicketsByApplicant(int pageIndex, int pageSize, String applicant);

    public BaseResponse<Boolean> cancelApply(DealApplicationRequest request);
}
