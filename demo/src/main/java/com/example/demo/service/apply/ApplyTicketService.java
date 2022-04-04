package com.example.demo.service.apply;


import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryApplyTicketResponse;

import java.util.List;

public interface ApplyTicketService {
    public BaseResponse<QueryApplyTicketResponse> queryAllApplyTickets(int pageIndex, int pageSize);

    public BaseResponse<Boolean> dealApplication(DealApplicationRequest request);
}
