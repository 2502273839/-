package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ApplyRequest implements Serializable {
    Integer roomId;

    String room;

    String start;

    String end;

    Date day;

    String applicant;

    String teacher;

    String lesson;

    String classHour;

    String content;
}
