package com.liu.site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("demo")
@RestController
public class DemoController1 {
    @GetMapping("/test")
    //http://127.0.0.1:8888/demo/test
    public String test(){
        return "start";
    }
}
