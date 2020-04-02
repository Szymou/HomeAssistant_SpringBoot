package com.szymou.homeassistant.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/boot/hello")
    public String jsp(Model model){
        model.addAttribute("date","测试jsp页面");
        return "index";
    }
}
