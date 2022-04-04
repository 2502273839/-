package com.example.demo.entity.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplyTicket implements Serializable {

    private int id;

    private String applicantName;

    private String roomName;

    private String processorName;

    private String createTime;

    private String startTime;

    private String endTime;
    /**
     * 状态： 0 - 待处理  1 - 同意  2 - 拒绝
     */
    private String status;

    private String applyReason;

    private String refuseReason;

}
