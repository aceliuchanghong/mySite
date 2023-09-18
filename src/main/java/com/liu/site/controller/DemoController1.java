package com.liu.site.controller;

import com.liu.site.mapper.StudentOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //请求页面和数据
public class DemoController1 {
    @Autowired
    private StudentOrderMapper studentOrderMapper;


    // http://127.0.0.1:8888/test
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name","lch");
        model.addAttribute("age","25");
        model.addAttribute("info","000");
        return  "00";
    }

    @RequestMapping("/test2/{id}")
    public String test2(@PathVariable String id) {
        return studentOrderMapper.selectOrderName1(id);
    }

}
