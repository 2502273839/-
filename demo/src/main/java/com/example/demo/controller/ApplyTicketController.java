package com.example.demo.controller;

import com.example.demo.model.request.ApplyRequest;
import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.apply.ApplyTicketServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class ApplyTicketController {

    @Resource
    ApplyTicketServiceImpl applyTicketService;

    @GetMapping("computer/applyticket/queryall")
    public BaseResponse queryAll(@RequestParam Integer page, @RequestParam Integer limit) {
        return applyTicketService.queryAllApplyTickets(page - 1, limit);
    }

    @PostMapping("computer/applyticket/deal")
    public BaseResponse dealApplication(@RequestBody DealApplicationRequest request) {
        return applyTicketService.dealApplication(request);
    }

    @PostMapping("computer/applyticket/apply")
    public BaseResponse apply(@RequestBody ApplyRequest request) {
        return applyTicketService.doApply(request);
    }
}
