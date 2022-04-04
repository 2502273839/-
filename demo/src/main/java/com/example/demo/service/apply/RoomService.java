package com.example.demo.service.apply;

import com.example.demo.model.request.RoomRequest;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryRoomResponse;

public interface RoomService {
    public BaseResponse<QueryRoomResponse> queryRoomUse(RoomRequest request);
}
