package com.szymou.homeassistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szymou.homeassistant.dao")
public class HomeAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeAssistantApplication.class, args);
    }

}
