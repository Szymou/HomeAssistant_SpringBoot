package com.szymou.homeassistant.mqtt;
/**
 * 配置MqttGateway消息推送接口类，在sendToMqtt(String data,@Header(MqttHeaders.TOPIC)String topic)接口中，
 * data为发送的消息内容，topic为主题。指定topic，则我们的接口可以根据需要，向不同的主题发送消息，方便灵活应用。
 * 如果不指定，则使用默认配置的主题。
 */

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGatewayConf {
    void sendToMqtt(String data,@Header(MqttHeaders.TOPIC) String topic);
}