package com.example.demo.controller;


import com.example.demo.Util.TokenPool;
import com.example.demo.entity.User;
import com.example.demo.model.request.LogoutRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.LoginServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class MainController {

    @Resource
    LoginServiceImpl loginService;

    @PostMapping("computer/user/login")
    public BaseResponse login(@RequestBody User user) {

        return loginService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("computer/user/info")
    public BaseResponse getInfo(@RequestParam String token) {
        Integer id = TokenPool.getUser(token);
        return loginService.getUserInfoById(id);
    }

    @PostMapping("computer/user/logout")
    public BaseResponse logout(@RequestHeader("X-Token") String token) {
        System.out.println(token + "---------");
        return loginService.logout(token);
    }

}
