package com.example.demo.dao;

import com.example.demo.entity.UserDO;
import com.example.demo.entity.UserDOExample;
import com.example.demo.mapper.UserDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceDAO {

    @Resource
    UserDOMapper userDOMapper;


    public UserDO queryUserByNameAndPassword(String userName, String passWord) {
        UserDOExample userDOExample = new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andUsernameEqualTo(userName).andPasswordEqualTo(passWord);
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        return userDOS.size() > 0 ? userDOS.get(0) : null;
    }

    public UserDO queryUserById(int id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return userDO;
    }

    public UserDO queryUserByName(String name) {
        UserDOExample example = new UserDOExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (userDOS.isEmpty()) {
            return null;
        }
        return userDOS.get(0);
    }

    public List<UserDO> queryAllTeacher() {
        UserDOExample example = new UserDOExample();
        example.createCriteria().andTypeEqualTo(0);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        return userDOS;
    }

}
