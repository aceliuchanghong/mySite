package com.liu.site.controller;

import com.liu.site.dao.UserMapper;
import com.liu.site.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    // http://127.0.0.1:8888/User/getAllUser2?id=1
    public User getAllUser2(@PathVariable String id) {
        return userMapper.getUserById(id);
    }


    @RequestMapping("/00")
    public String test(Model model) {
        model.addAttribute("name","lch");
        model.addAttribute("age","25");
        model.addAttribute("info","000");
        return "00";
    }



}
