package com.example.demo.service.login;

import com.example.demo.model.response.BaseResponse;

public interface LoginService {

    /**
     * 登录接口
     * @param userName
     * @param passWord
     * @return token
     */
    public BaseResponse login(String userName, String passWord);


    public BaseResponse getUserInfoById(int id);

    public BaseResponse logout(String token);
}
