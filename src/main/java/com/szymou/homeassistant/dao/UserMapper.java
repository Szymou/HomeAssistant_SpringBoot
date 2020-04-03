package com.szymou.homeassistant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szymou.homeassistant.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {

}
