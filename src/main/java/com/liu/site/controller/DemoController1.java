package com.liu.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //请求页面和数据
public class DemoController1 {



    // http://127.0.0.1:8888/test
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name","lch");
        model.addAttribute("age","25");
        model.addAttribute("info","000");
        return  "00";
    }


}
