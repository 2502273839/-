package com.example.demo.controller;

import com.example.demo.model.request.ApplyRequest;
import com.example.demo.model.request.DealApplicationRequest;
import com.example.demo.model.request.QueryApplyTicketRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.apply.ApplyTicketServiceImpl;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class ApplyTicketController {

    @Resource
    ApplyTicketServiceImpl applyTicketService;

    @GetMapping("computer/applyticket/queryall")
    public BaseResponse queryAll(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam @Nullable String applicant, @RequestParam @Nullable String status) {
        QueryApplyTicketRequest request = new QueryApplyTicketRequest();
        request.setPageIndex(page - 1);
        request.setPageSize(limit);
        request.setApplicant(applicant);
        request.setStatus(status);
        return applyTicketService.queryAllApplyTickets(request);
    }

    @GetMapping("computer/applyticket/queryallbyname")
    public BaseResponse queryAllByName(@RequestParam Integer page, @RequestParam Integer limit, @RequestParam String applicant) {
        return applyTicketService.queryApplyTicketsByApplicant(page - 1, limit, applicant);
    }

    @PostMapping("computer/applyticket/deal")
    public BaseResponse dealApplication(@RequestBody DealApplicationRequest request) {
        return applyTicketService.dealApplication(request);
    }

    @PostMapping("computer/applyticket/apply")
    public BaseResponse apply(@RequestBody ApplyRequest request) {
        return applyTicketService.doApply(request);
    }

    @PostMapping("computer/applyticket/cancel")
    public BaseResponse cancelApplication(@RequestBody DealApplicationRequest request) {
        return applyTicketService.cancelApply(request);
    }

    @GetMapping("computer/applyticket/queryalldownload")
    public BaseResponse downloadList(@RequestParam @Nullable String applicant, @RequestParam @Nullable String status) {
        QueryApplyTicketRequest request = new QueryApplyTicketRequest();
        request.setPageIndex(-1);
        request.setApplicant(applicant);
        request.setStatus(status);
        return applyTicketService.queryAllApplyTickets(request);
    }

}
