package com.szymou.homeassistant.controller;


import com.szymou.homeassistant.dao.UserInfoDao;
import com.szymou.homeassistant.dao.UserMapper;
import com.szymou.homeassistant.entity.User;
import com.szymou.homeassistant.service.UserService;
import com.szymou.homeassistant.util.token.TokenService;
import com.szymou.homeassistant.util.token.TokenUtil;
import com.szymou.homeassistant.util.token.UserLoginToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/boot")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    TokenService tokenService;

    @RequestMapping("reg")
    public @ResponseBody String register(User user){
        user.setuId(UUID.randomUUID().toString().substring(2,8));
        user.setuName("cyh");
        userMapper.insert(user);
        return "null";
    }

//    @RequestMapping("login")
//    public String login(User user) throws Exception {
//        user.setuId("ffd083");
//        String result = userService.login(user);
//        return result;
//    }

    // 登录
    @GetMapping("/login")
    public Object login(User user, HttpServletResponse response) throws JSONException {
        user = userMapper.selectById("1");//假装在前端传过来
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        userForBase.setuId("1");
        userForBase.setuPassword("123");
        userForBase.setuName("cyh");

        if (!userForBase.getuPassword().equals(user.getuPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);

            return jsonObject;

        }
    }

    /***
     * 这个请求需要验证token才能访问
     *
     * @author: MRC
     * @date 2019年5月27日 下午5:45:19
     * @return String 返回类型
     */
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        System.out.println(TokenUtil.getTokenUserId());

        return "你已通过验证";
    }

}
