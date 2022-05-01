package com.example.demo.entity.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    Integer userId;

    String userName;

    String classHour;

    Integer applyNum;
}
