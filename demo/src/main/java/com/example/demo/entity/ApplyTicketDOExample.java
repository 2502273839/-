package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyTicketDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyTicketDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApplicantidIsNull() {
            addCriterion("applicantId is null");
            return (Criteria) this;
        }

        public Criteria andApplicantidIsNotNull() {
            addCriterion("applicantId is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantidEqualTo(Integer value) {
            addCriterion("applicantId =", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidNotEqualTo(Integer value) {
            addCriterion("applicantId <>", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidGreaterThan(Integer value) {
            addCriterion("applicantId >", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidGreaterThanOrEqualTo(Integer value) {
            addCriterion("applicantId >=", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidLessThan(Integer value) {
            addCriterion("applicantId <", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidLessThanOrEqualTo(Integer value) {
            addCriterion("applicantId <=", value, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidIn(List<Integer> values) {
            addCriterion("applicantId in", values, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidNotIn(List<Integer> values) {
            addCriterion("applicantId not in", values, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidBetween(Integer value1, Integer value2) {
            addCriterion("applicantId between", value1, value2, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantidNotBetween(Integer value1, Integer value2) {
            addCriterion("applicantId not between", value1, value2, "applicantid");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomId is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomId is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(Integer value) {
            addCriterion("roomId =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(Integer value) {
            addCriterion("roomId <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(Integer value) {
            addCriterion("roomId >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomId >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(Integer value) {
            addCriterion("roomId <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(Integer value) {
            addCriterion("roomId <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<Integer> values) {
            addCriterion("roomId in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<Integer> values) {
            addCriterion("roomId not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(Integer value1, Integer value2) {
            addCriterion("roomId between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(Integer value1, Integer value2) {
            addCriterion("roomId not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNull() {
            addCriterion("roomName is null");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNotNull() {
            addCriterion("roomName is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnameEqualTo(String value) {
            addCriterion("roomName =", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotEqualTo(String value) {
            addCriterion("roomName <>", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThan(String value) {
            addCriterion("roomName >", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThanOrEqualTo(String value) {
            addCriterion("roomName >=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThan(String value) {
            addCriterion("roomName <", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThanOrEqualTo(String value) {
            addCriterion("roomName <=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLike(String value) {
            addCriterion("roomName like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotLike(String value) {
            addCriterion("roomName not like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameIn(List<String> values) {
            addCriterion("roomName in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotIn(List<String> values) {
            addCriterion("roomName not in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameBetween(String value1, String value2) {
            addCriterion("roomName between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotBetween(String value1, String value2) {
            addCriterion("roomName not between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeIsNull() {
            addCriterion("addressTime is null");
            return (Criteria) this;
        }

        public Criteria andAddresstimeIsNotNull() {
            addCriterion("addressTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddresstimeEqualTo(Date value) {
            addCriterion("addressTime =", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeNotEqualTo(Date value) {
            addCriterion("addressTime <>", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeGreaterThan(Date value) {
            addCriterion("addressTime >", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addressTime >=", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeLessThan(Date value) {
            addCriterion("addressTime <", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeLessThanOrEqualTo(Date value) {
            addCriterion("addressTime <=", value, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeIn(List<Date> values) {
            addCriterion("addressTime in", values, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeNotIn(List<Date> values) {
            addCriterion("addressTime not in", values, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeBetween(Date value1, Date value2) {
            addCriterion("addressTime between", value1, value2, "addresstime");
            return (Criteria) this;
        }

        public Criteria andAddresstimeNotBetween(Date value1, Date value2) {
            addCriterion("addressTime not between", value1, value2, "addresstime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("modifiedTime is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("modifiedTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(Date value) {
            addCriterion("modifiedTime =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(Date value) {
            addCriterion("modifiedTime <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(Date value) {
            addCriterion("modifiedTime >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifiedTime >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(Date value) {
            addCriterion("modifiedTime <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("modifiedTime <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<Date> values) {
            addCriterion("modifiedTime in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<Date> values) {
            addCriterion("modifiedTime not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(Date value1, Date value2) {
            addCriterion("modifiedTime between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("modifiedTime not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andProcessoridIsNull() {
            addCriterion("processorId is null");
            return (Criteria) this;
        }

        public Criteria andProcessoridIsNotNull() {
            addCriterion("processorId is not null");
            return (Criteria) this;
        }

        public Criteria andProcessoridEqualTo(Integer value) {
            addCriterion("processorId =", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridNotEqualTo(Integer value) {
            addCriterion("processorId <>", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridGreaterThan(Integer value) {
            addCriterion("processorId >", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("processorId >=", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridLessThan(Integer value) {
            addCriterion("processorId <", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridLessThanOrEqualTo(Integer value) {
            addCriterion("processorId <=", value, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridIn(List<Integer> values) {
            addCriterion("processorId in", values, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridNotIn(List<Integer> values) {
            addCriterion("processorId not in", values, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridBetween(Integer value1, Integer value2) {
            addCriterion("processorId between", value1, value2, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessoridNotBetween(Integer value1, Integer value2) {
            addCriterion("processorId not between", value1, value2, "processorid");
            return (Criteria) this;
        }

        public Criteria andProcessornameIsNull() {
            addCriterion("processorName is null");
            return (Criteria) this;
        }

        public Criteria andProcessornameIsNotNull() {
            addCriterion("processorName is not null");
            return (Criteria) this;
        }

        public Criteria andProcessornameEqualTo(String value) {
            addCriterion("processorName =", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameNotEqualTo(String value) {
            addCriterion("processorName <>", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameGreaterThan(String value) {
            addCriterion("processorName >", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameGreaterThanOrEqualTo(String value) {
            addCriterion("processorName >=", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameLessThan(String value) {
            addCriterion("processorName <", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameLessThanOrEqualTo(String value) {
            addCriterion("processorName <=", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameLike(String value) {
            addCriterion("processorName like", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameNotLike(String value) {
            addCriterion("processorName not like", value, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameIn(List<String> values) {
            addCriterion("processorName in", values, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameNotIn(List<String> values) {
            addCriterion("processorName not in", values, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameBetween(String value1, String value2) {
            addCriterion("processorName between", value1, value2, "processorname");
            return (Criteria) this;
        }

        public Criteria andProcessornameNotBetween(String value1, String value2) {
            addCriterion("processorName not between", value1, value2, "processorname");
            return (Criteria) this;
        }

        public Criteria andApplyreasonIsNull() {
            addCriterion("applyreason is null");
            return (Criteria) this;
        }

        public Criteria andApplyreasonIsNotNull() {
            addCriterion("applyreason is not null");
            return (Criteria) this;
        }

        public Criteria andApplyreasonEqualTo(String value) {
            addCriterion("applyreason =", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonNotEqualTo(String value) {
            addCriterion("applyreason <>", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonGreaterThan(String value) {
            addCriterion("applyreason >", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonGreaterThanOrEqualTo(String value) {
            addCriterion("applyreason >=", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonLessThan(String value) {
            addCriterion("applyreason <", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonLessThanOrEqualTo(String value) {
            addCriterion("applyreason <=", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonLike(String value) {
            addCriterion("applyreason like", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonNotLike(String value) {
            addCriterion("applyreason not like", value, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonIn(List<String> values) {
            addCriterion("applyreason in", values, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonNotIn(List<String> values) {
            addCriterion("applyreason not in", values, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonBetween(String value1, String value2) {
            addCriterion("applyreason between", value1, value2, "applyreason");
            return (Criteria) this;
        }

        public Criteria andApplyreasonNotBetween(String value1, String value2) {
            addCriterion("applyreason not between", value1, value2, "applyreason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIsNull() {
            addCriterion("refusereason is null");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIsNotNull() {
            addCriterion("refusereason is not null");
            return (Criteria) this;
        }

        public Criteria andRefusereasonEqualTo(String value) {
            addCriterion("refusereason =", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotEqualTo(String value) {
            addCriterion("refusereason <>", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonGreaterThan(String value) {
            addCriterion("refusereason >", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonGreaterThanOrEqualTo(String value) {
            addCriterion("refusereason >=", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLessThan(String value) {
            addCriterion("refusereason <", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLessThanOrEqualTo(String value) {
            addCriterion("refusereason <=", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonLike(String value) {
            addCriterion("refusereason like", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotLike(String value) {
            addCriterion("refusereason not like", value, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonIn(List<String> values) {
            addCriterion("refusereason in", values, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotIn(List<String> values) {
            addCriterion("refusereason not in", values, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonBetween(String value1, String value2) {
            addCriterion("refusereason between", value1, value2, "refusereason");
            return (Criteria) this;
        }

        public Criteria andRefusereasonNotBetween(String value1, String value2) {
            addCriterion("refusereason not between", value1, value2, "refusereason");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}