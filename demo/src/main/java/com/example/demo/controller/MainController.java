package com.example.demo.controller;


import com.example.demo.Util.Switch;
import com.example.demo.Util.TokenPool;
import com.example.demo.entity.client.User;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.apply.ApplyTicketServiceImpl;
import com.example.demo.serviceImpl.login.LoginServiceImpl;
import com.example.demo.serviceImpl.user.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class MainController {

    @Resource
    LoginServiceImpl loginService;

    @Resource
    UserServiceImpl userService;

    @PostMapping("computer/user/login")
    public BaseResponse login(@RequestBody User user) {

        return loginService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("computer/user/info")
    public BaseResponse getInfo(@RequestParam String token) {
        Integer id = TokenPool.getUser(token);
        if (id == null) {
            return BaseResponse.returnFailData("301", "用户未登录");
        }
        return loginService.getUserInfoById(id);
    }

    @PostMapping("computer/user/logout")
    public BaseResponse logout(@RequestHeader("X-Token") String token) {
        System.out.println(token + "---------");
        return loginService.logout(token);
    }

    @GetMapping("computer/user/changeauto")
    public BaseResponse changeAuto(@RequestParam Boolean isOpen) {
        Switch.openAutoProcess = isOpen;
        return BaseResponse.returnSuccessData(true);
    }

    @GetMapping("computer/user/getauto")
    public BaseResponse getAuto() {
        return BaseResponse.returnSuccessData(Switch.openAutoProcess);
    }

    @GetMapping("computer/user/queryallteacher")
    public BaseResponse getAllTeacherInfo() {
        return userService.queryAllTeacher();
    }

}
