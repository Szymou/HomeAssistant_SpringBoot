package com.szymou.homeassistant.service.impl;

import com.szymou.homeassistant.dao.UserMapper;
import com.szymou.homeassistant.entity.User;
import com.szymou.homeassistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String register(User user) {

        return null;
    }

    @Override
    public String login(User user) throws Exception {
        String result = "登录失败";
        User userInfo = userMapper.selectById(user.getuId());
        if(user.getuPassword() == null || "".equals(user.getuPassword())){
            throw new Exception("请输入密码！");
        }
        if(user.getuPassword().equals(userInfo.getuPassword())){
            System.out.println("登陆成功");
            result = "登陆成功";
        }
        return result;
    }
}
