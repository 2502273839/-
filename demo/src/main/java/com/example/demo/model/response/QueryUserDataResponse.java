package com.example.demo.model.response;

import com.example.demo.entity.client.UserInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryUserDataResponse implements Serializable {

    List<UserInfo> userInfoList;

    int total;
}
