package com.example.demo.mapper;

import com.example.demo.entity.RoomUseDO;
import com.example.demo.entity.RoomUseDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoomUseDOMapper {
    int countByExample(RoomUseDOExample example);

    int deleteByExample(RoomUseDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomUseDO record);

    int insertSelective(RoomUseDO record);

    List<RoomUseDO> selectByExampleWithRowbounds(RoomUseDOExample example, RowBounds rowBounds);

    List<RoomUseDO> selectByExample(RoomUseDOExample example);

    RoomUseDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomUseDO record, @Param("example") RoomUseDOExample example);

    int updateByExample(@Param("record") RoomUseDO record, @Param("example") RoomUseDOExample example);

    int updateByPrimaryKeySelective(RoomUseDO record);

    int updateByPrimaryKey(RoomUseDO record);
}