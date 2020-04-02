package com.szymou.homeassistant.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

//定时任务--需要在启动类开启定时任务
@Component
public class Task {

//    @Scheduled(fixedDelay = 3000)
//    public void testTask(){
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//    }
}
