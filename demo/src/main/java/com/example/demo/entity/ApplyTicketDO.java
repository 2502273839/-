package com.example.demo.entity;

import java.util.Date;

public class ApplyTicketDO {
    private Integer id;

    private Integer applicantid;

    private String applicant;

    private Date starttime;

    private Date endtime;

    private Integer roomid;

    private String roomname;

    private Integer status;

    private Date createtime;

    private Date addresstime;

    private Date modifiedtime;

    private Integer processorid;

    private String processorname;

    private String applyreason;

    private String refusereason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(Integer applicantid) {
        this.applicantid = applicantid;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getAddresstime() {
        return addresstime;
    }

    public void setAddresstime(Date addresstime) {
        this.addresstime = addresstime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Integer getProcessorid() {
        return processorid;
    }

    public void setProcessorid(Integer processorid) {
        this.processorid = processorid;
    }

    public String getProcessorname() {
        return processorname;
    }

    public void setProcessorname(String processorname) {
        this.processorname = processorname == null ? null : processorname.trim();
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason == null ? null : applyreason.trim();
    }

    public String getRefusereason() {
        return refusereason;
    }

    public void setRefusereason(String refusereason) {
        this.refusereason = refusereason == null ? null : refusereason.trim();
    }
}