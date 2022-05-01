package com.example.demo.dao;

import com.example.demo.Util.DateUtil;
import com.example.demo.entity.RoomDO;
import com.example.demo.entity.RoomDOExample;
import com.example.demo.entity.RoomUseDO;
import com.example.demo.entity.RoomUseDOExample;
import com.example.demo.mapper.RoomDOMapper;
import com.example.demo.mapper.RoomUseDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceDAO {
    @Resource
    RoomDOMapper roomDOMapper;

    @Resource
    RoomUseDOMapper roomUseDOMapper;

    public List<RoomUseDO> queryRoomUseById(Integer roomId) {
        RoomUseDOExample example = new RoomUseDOExample();
        example.createCriteria().andRoomidEqualTo(roomId);
        List<RoomUseDO> roomUseDOS = roomUseDOMapper.selectByExample(example);
        return roomUseDOS;
    }

    public List<RoomUseDO> queryRoomUseByDay(Date day) {
        String s = DateUtil.parseDateByDay(day);
        RoomUseDOExample example = new RoomUseDOExample();
        example.createCriteria().andDayEqualTo(s);
        List<RoomUseDO> roomUseDOS = roomUseDOMapper.selectByExample(example);
        return roomUseDOS;
    }

    public List<RoomDO> queryAllRoom() {
        List<RoomDO> roomDOS = roomDOMapper.selectByExample(new RoomDOExample());
        return roomDOS;
    }

    public boolean insertRoomUse(RoomUseDO roomUseDO) {
        int insert = roomUseDOMapper.insert(roomUseDO);
        return insert == 1;
    }

}
