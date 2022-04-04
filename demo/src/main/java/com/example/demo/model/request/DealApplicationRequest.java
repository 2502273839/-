package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DealApplicationRequest implements Serializable {
    /**
     * 拒绝原因 若同意则为空
     */
    String reason;

    /**
     * 操作人name
     */
    String operatorName;

    /**
     *  申请单id
     */
    Integer applicationId;

    /**
     * 申请单 状态 1--同意  2--拒绝
     */
    String status;

}
