package com.szymou.homeassistant.controller;

import com.szymou.homeassistant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boot")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("test")
    public String Test(){
//        UserInfo a = userInfoService
        return "123789";
    }

}
