package com.liu.site.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ParamController {
    // http://127.0.0.1:8888/api/hello?nickname=liu&phone=139
    @RequestMapping("hello")
    public String hello(String nickname, String phone) {
        return "hello " + nickname + (phone == null ? "" : ", your phone is:" + phone);
    }
}
