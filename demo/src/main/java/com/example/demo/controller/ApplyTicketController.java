package com.example.demo.controller;

import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.apply.ApplyTicketServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApplyTicketController {

    @Resource
    ApplyTicketServiceImpl applyTicketService;

    @PostMapping("computer/applyticket/queryall")
    public BaseResponse queryAll(QueryApplyTicketRequest request) {
        return applyTicketService.queryAllApplyTickets(request);
    }
}
