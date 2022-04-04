package com.example.demo.model;

import lombok.Data;

public enum ErrorCode {

    SYSTEM_ERROR("300", "系统错误");




    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
    String code;
    String message;

}
