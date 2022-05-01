package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DealApplicationRequest implements Serializable {

    /**
     * 操作人name
     */
    String operatorName;

    /**
     *  申请单id
     */
    Integer applicationId;

    /**
     * 申请单 状态 1--同意  2--拒绝  3--撤销  4--确认
     */
    String status;

}
