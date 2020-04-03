package com.szymou.homeassistant.service;

import com.szymou.homeassistant.entity.User;

public interface UserService {

    public String register(User user);

    public String login(User user) throws Exception;


}
