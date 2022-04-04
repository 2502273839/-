package com.example.demo.entity;

import java.util.Date;

public class RoomUseDO {
    private Integer id;

    private Integer roomid;

    private Date start;

    private Date end;

    private String day;

    private Integer applyTicketId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Integer getApplyTicketId() {
        return applyTicketId;
    }

    public void setApplyTicketId(Integer applyTicketId) {
        this.applyTicketId = applyTicketId;
    }
}