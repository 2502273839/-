package com.example.demo.dao;

import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.ApplyTicketDOExample;
import com.example.demo.mapper.ApplyTicketDOMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ApplyTicketServiceDAO {
    @Resource
    ApplyTicketDOMapper applyTicketDOMapper;

    public List<ApplyTicketDO> queryAll(int pageIndex, int pageSize) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExampleWithRowbounds(example, new RowBounds(pageIndex * pageSize, pageSize));
        return applyTicketDOS;
    }

    public int queryAllCount() {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExample(example);
        return applyTicketDOS.size();
    }

    public boolean update(ApplyTicketDO applyTicketDO) {
        int i = applyTicketDOMapper.updateByPrimaryKeySelective(applyTicketDO);
        return i == 1;
    }

    public boolean insertApplyTicket(ApplyTicketDO applyTicketDO) {
        return applyTicketDOMapper.insert(applyTicketDO) == 1;
    }
}
