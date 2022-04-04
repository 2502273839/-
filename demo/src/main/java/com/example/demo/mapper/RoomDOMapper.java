package com.example.demo.mapper;

import com.example.demo.entity.RoomDO;
import com.example.demo.entity.RoomDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoomDOMapper {
    int countByExample(RoomDOExample example);

    int deleteByExample(RoomDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomDO record);

    int insertSelective(RoomDO record);

    List<RoomDO> selectByExampleWithRowbounds(RoomDOExample example, RowBounds rowBounds);

    List<RoomDO> selectByExample(RoomDOExample example);

    RoomDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomDO record, @Param("example") RoomDOExample example);

    int updateByExample(@Param("record") RoomDO record, @Param("example") RoomDOExample example);

    int updateByPrimaryKeySelective(RoomDO record);

    int updateByPrimaryKey(RoomDO record);
}