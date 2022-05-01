package com.example.demo.model;

import lombok.Data;

public enum ErrorCode {

    SYSTEM_ERROR("300", "系统错误"),
    USER_FAIL_AUTH("400", "用户验证失败");



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
