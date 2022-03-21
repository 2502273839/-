package com.example.demo.serviceImpl;

import com.example.demo.Util.StringUtils;
import com.example.demo.Util.TokenPool;
import com.example.demo.dao.UserServiceDAO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDO;
import com.example.demo.model.response.BaseResponse;
import com.example.demo.model.response.LoginResponse;
import com.example.demo.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    UserServiceDAO userServiceDAO;

    @Override
    public BaseResponse login(String userName, String passWord) {
        UserDO userDO = userServiceDAO.queryUserByNameAndPassword(userName, passWord);
        if (userDO != null) {
            String token = TokenPool.getUUID();
            TokenPool.setToken(token, userDO.getUserid());
            logger.info("生成令牌 {}, 用户名为 {}", token, userDO.getUsername());
            return BaseResponse.returnSuccessData(new LoginResponse(token));
        }
        return new BaseResponse("400", "用户未注册", System.currentTimeMillis());
    }

    @Override
    public BaseResponse getUserInfoById(int id) {
        UserDO userDO = userServiceDAO.queryUserById(id);
        User user = new User(userDO);
        return BaseResponse.returnSuccessData(user);
    }

    @Override
    public BaseResponse logout(String token) {
        if (!StringUtils.isEmpty(token)) {
            TokenPool.deleteToken(token);
            return BaseResponse.returnSuccessData(true);
        }
        return BaseResponse.returnSuccessData(false);
    }
}
