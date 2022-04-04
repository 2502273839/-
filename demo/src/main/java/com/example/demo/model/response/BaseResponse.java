package com.example.demo.model.response;



import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 6586972769859976560L;

    private String code;

    private String message;

    private long timestamp;

    private T data;

    public BaseResponse(String code, String message, long timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public static <T> BaseResponse<T> returnSuccessData(T data) {
        BaseResponse<T> response = new BaseResponse<>("200", "success", System.currentTimeMillis());
        response.data = data;
        return response;
    }

    public static <T> BaseResponse<T> returnFailData(String code, String message) {
        BaseResponse<T> response = new BaseResponse<>(code, message, System.currentTimeMillis());
        return response;
    }



}
