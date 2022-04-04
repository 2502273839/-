package com.example.demo.model.response;

import com.example.demo.entity.client.RoomUse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryRoomResponse implements Serializable {
    int total;

    List<RoomUse> roomUseList;
}
