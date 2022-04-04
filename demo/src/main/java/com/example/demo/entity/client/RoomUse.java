package com.example.demo.entity.client;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomUse implements Serializable {
    /**
     * 房间id
     */
    int roomId;

    /**
     * 门牌号
     */
    String room;

    /**
     * 机器数量
     */
    int nums;

    /**
     * 是否可用
     */
    String access;

    /**
     *  可用时间
     */
    String accessTime;
}
