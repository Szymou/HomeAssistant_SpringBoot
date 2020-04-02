package com.szymou.homeassistant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szymou.homeassistant.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoDao extends BaseMapper<UserInfo> {
    @Select("select * from user_info")
    List<UserInfo> fingUserInfo();

    List<UserInfo> findAll();

    IPage<UserInfo> findAllByPage(Page page);
}
