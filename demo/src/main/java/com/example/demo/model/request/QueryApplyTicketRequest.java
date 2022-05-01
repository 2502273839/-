package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryApplyTicketRequest extends TableRequest {

    /**
     * 申请人
     */
    String applicant;

    /**
     * 申请单状态
     */
    String status;
}
