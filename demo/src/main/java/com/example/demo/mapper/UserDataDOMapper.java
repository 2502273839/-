package com.example.demo.mapper;

import com.example.demo.entity.UserDataDO;
import com.example.demo.entity.UserDataDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserDataDOMapper {
    int countByExample(UserDataDOExample example);

    int deleteByExample(UserDataDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDataDO record);

    int insertSelective(UserDataDO record);

    List<UserDataDO> selectByExampleWithRowbounds(UserDataDOExample example, RowBounds rowBounds);

    List<UserDataDO> selectByExample(UserDataDOExample example);

    UserDataDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDataDO record, @Param("example") UserDataDOExample example);

    int updateByExample(@Param("record") UserDataDO record, @Param("example") UserDataDOExample example);

    int updateByPrimaryKeySelective(UserDataDO record);

    int updateByPrimaryKey(UserDataDO record);
}