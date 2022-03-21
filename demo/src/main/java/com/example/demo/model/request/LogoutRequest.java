package com.example.demo.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogoutRequest implements Serializable {

    private static final long serialVersionUID = -4492461841597556027L;

    String token;
}
