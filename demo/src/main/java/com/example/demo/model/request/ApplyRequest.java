package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplyRequest implements Serializable {
    Integer roomId;

    String room;

    Date start;

    Date end;

    String applicant;

    String applyReason;
}
