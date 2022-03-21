package com.example.demo.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 2011916119218987655L;

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
