package com.example.demo.serviceImpl.user;

import com.example.demo.dao.UserDataServiceDAO;
import com.example.demo.dao.UserServiceDAO;
import com.example.demo.entity.UserDO;
import com.example.demo.entity.UserDataDO;
import com.example.demo.entity.client.UserInfo;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.QueryUserDataResponse;
import com.example.demo.service.user.UserSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserSerivce {

    @Resource
    UserServiceDAO userServiceDAO;

    @Resource
    UserDataServiceDAO userDataServiceDAO;

    public BaseResponse<QueryUserDataResponse> queryAllTeacher() {
        List<UserDO> userDOS = userServiceDAO.queryAllTeacher();
        List<UserDataDO> userDataDOS = userDataServiceDAO.getAllUserData();
        Map<Integer, UserDataDO> userData = userDataDOS.stream().collect(Collectors.toMap(UserDataDO::getUserid, u -> u));
        List<UserInfo> list = new ArrayList<>(userDOS.size());
        for (UserDO userDO : userDOS) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userDO.getUserid());
            userInfo.setUserName(userDO.getUsername());
            UserDataDO userDataDO = userData.get(userDO.getUserid());
            if (userDataDO != null) {
                userInfo.setApplyNum(userDataDO.getApplyNum());
                userInfo.setClassHour(userDataDO.getClassHour());
            }
            list.add(userInfo);
        }
        QueryUserDataResponse queryUserDataResponse = new QueryUserDataResponse();
        queryUserDataResponse.setTotal(list.size());
        queryUserDataResponse.setUserInfoList(list);
        return BaseResponse.returnSuccessData(queryUserDataResponse);
    }
}
