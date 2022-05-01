package com.example.demo.dao;

import com.example.demo.entity.UserDataDO;
import com.example.demo.entity.UserDataDOExample;
import com.example.demo.mapper.UserDataDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserDataServiceDAO {
    @Resource
    UserDataDOMapper userDataDOMapper;

    public List<UserDataDO> getAllUserData() {
        UserDataDOExample example = new UserDataDOExample();
        List<UserDataDO> userDataDOS = userDataDOMapper.selectByExample(example);
        return userDataDOS;
    }

    public UserDataDO getUserDataByUserId(Integer userId) {
        UserDataDOExample example = new UserDataDOExample();
        UserDataDOExample.Criteria criteria = example.createCriteria().andUseridEqualTo(userId);
        List<UserDataDO> userDataDOS = userDataDOMapper.selectByExample(example);
        if (userDataDOS.isEmpty()) {
            return null;
        }
        return userDataDOS.get(0);
    }

    public void insertUserData(UserDataDO userDataDO) {
        userDataDOMapper.insert(userDataDO);
    }
}
