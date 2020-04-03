package com.szymou.homeassistant.controller;

import com.szymou.homeassistant.mqtt.MqttGatewayConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boot")
public class MqttController {

    @Autowired
    MqttGatewayConf mqttGatewayConf;

    @RequestMapping("/mqtt")
    public void mqttTest(String data,String topic){
        String defaultTopic = "8266light/switch/8266light_logo_light/command";
        if(topic != null){
            defaultTopic = topic;
        }
        mqttGatewayConf.sendToMqtt(data,defaultTopic);
    }
}
