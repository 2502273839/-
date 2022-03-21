package com.example.demo.dao;

import com.example.demo.entity.UserDO;
import com.example.demo.entity.UserDOExample;
import com.example.demo.mapper.UserDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class Test {
//    @Resource
//    DataSource source;

    @Resource
    UserDOMapper userDOMapper;

    public void test() throws SQLException {
//        Connection connection = source.getConnection();
//        PreparedStatement statement = connection.prepareStatement("select * from user where userId = 1");
//        boolean execute = statement.execute();
//        statement.close();
//        connection.close();
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo("胡超");
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        for (UserDO userDO : userDOS) {
            System.out.println(userDO.getPhone());
        }
    }
}
