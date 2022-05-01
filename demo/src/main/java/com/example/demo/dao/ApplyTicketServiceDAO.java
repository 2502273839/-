package com.example.demo.dao;

import com.example.demo.entity.ApplyTicketDO;
import com.example.demo.entity.ApplyTicketDOExample;
import com.example.demo.mapper.ApplyTicketDOMapper;
import com.example.demo.model.request.QueryApplyTicketRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ApplyTicketServiceDAO {
    @Resource
    ApplyTicketDOMapper applyTicketDOMapper;

    public ApplyTicketDO queryById(Integer id) {
        return applyTicketDOMapper.selectByPrimaryKey(id);
    }

    public List<ApplyTicketDO> queryAllByPage(QueryApplyTicketRequest request) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        int pageIndex = request.getPageIndex();
        int pageSize = request.getPageSize();
        if (request.getApplicant() != null && !request.getApplicant().isEmpty()) {
            criteria.andApplicantEqualTo(request.getApplicant());
        }
        if (request.getStatus() != null && !request.getStatus().isEmpty()) {
            criteria.andStatusEqualTo(Integer.valueOf(request.getStatus()));
        }
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExampleWithRowbounds(example, new RowBounds(pageIndex * pageSize, pageSize));
        return applyTicketDOS;
    }

    public List<ApplyTicketDO> queryAll(QueryApplyTicketRequest request) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        if (request.getApplicant() != null && !request.getApplicant().isEmpty()) {
            criteria.andApplicantEqualTo(request.getApplicant());
        }
        if (request.getStatus() != null && !request.getStatus().isEmpty()) {
            criteria.andStatusEqualTo(Integer.valueOf(request.getStatus()));
        }
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExample(example);
        return applyTicketDOS;
    }

    public int queryAllCount(QueryApplyTicketRequest request) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        if (request.getApplicant() != null && !request.getApplicant().isEmpty()) {
            criteria.andApplicantEqualTo(request.getApplicant());
        }
        if (request.getStatus() != null && !request.getStatus().isEmpty()) {
            criteria.andStatusEqualTo(Integer.valueOf(request.getStatus()));
        }
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExample(example);
        return applyTicketDOS.size();
    }

    public boolean update(ApplyTicketDO applyTicketDO) {
        int i = applyTicketDOMapper.updateByPrimaryKeySelective(applyTicketDO);
        return i == 1;
    }

    public int insertApplyTicket(ApplyTicketDO applyTicketDO) {
        return applyTicketDOMapper.insert(applyTicketDO);
    }

    public void insertApplyTicketSelective(ApplyTicketDO applyTicketDO) {
        applyTicketDOMapper.insertSelective(applyTicketDO);
    }


    public List<ApplyTicketDO> queryAllByName(int pageIndex, int pageSize, String name) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        example.createCriteria().andApplicantEqualTo(name);
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExampleWithRowbounds(example, new RowBounds(pageIndex * pageSize, pageSize));
        return applyTicketDOS;
    }

    public int queryCountByName(String name) {
        ApplyTicketDOExample example = new ApplyTicketDOExample();
        ApplyTicketDOExample.Criteria criteria = example.createCriteria();
        criteria.andApplicantEqualTo(name);
        List<ApplyTicketDO> applyTicketDOS = applyTicketDOMapper.selectByExample(example);
        return applyTicketDOS.size();
    }
}
