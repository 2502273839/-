package com.example.demo.controller;

import com.example.demo.entity.client.User;
import com.example.demo.model.request.RoomRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.serviceImpl.apply.RoomServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class RoomController {

    @Resource
    RoomServiceImpl roomService;

    @PostMapping("computer/room/queryUse")
    public BaseResponse queryRoomUse(@RequestBody RoomRequest request) {
        return roomService.queryRoomUse(request);
    }
}
