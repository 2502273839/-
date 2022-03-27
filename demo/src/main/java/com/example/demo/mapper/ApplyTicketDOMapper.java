package com.example.demo.mapper;

import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.ApplyTicketDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplyTicketDOMapper {
    int countByExample(ApplyTicketDOExample example);

    int deleteByExample(ApplyTicketDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyTicketDO record);

    int insertSelective(ApplyTicketDO record);

    List<ApplyTicketDO> selectByExampleWithRowbounds(ApplyTicketDOExample example, RowBounds rowBounds);

    List<ApplyTicketDO> selectByExample(ApplyTicketDOExample example);

    ApplyTicketDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyTicketDO record, @Param("example") ApplyTicketDOExample example);

    int updateByExample(@Param("record") ApplyTicketDO record, @Param("example") ApplyTicketDOExample example);

    int updateByPrimaryKeySelective(ApplyTicketDO record);

    int updateByPrimaryKey(ApplyTicketDO record);
}