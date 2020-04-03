package com.szymou.homeassistant.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.szymou.homeassistant.dao.UserInfoDao;
import com.szymou.homeassistant.entity.UserInfo;
import com.szymou.homeassistant.mqtt.MqttGatewayConf;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private UserInfoDao userMapper;

    @Autowired
    MqttGatewayConf mqttGateway;

    @org.junit.Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserInfo> userList = userMapper.selectList(null);
        for(UserInfo user : userList){
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void test(){
//        System.out.println(userMapper.fingUserInfo().get(1));   //注解方式
        System.out.println(userMapper.findAll().get(1));   //在xml写sqk方式
    }

    /**
     * 分页查询
     */
    @org.junit.Test
    public void testPage(){
        //查询第几页，每页几个
        Page page = new Page(2,5);
        IPage<UserInfo> infoIPage = userMapper.findAllByPage(page);
        System.out.println(infoIPage);
    }


    @org.junit.Test
    public void sendMqtt(){
        mqttGateway.sendToMqtt("OFF","8266light/switch/8266light_logo_light/command");
//        return "OK";
    }
}