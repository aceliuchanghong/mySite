package com.liu.site.controller;

import com.liu.site.dao.UserMapper;
import com.liu.site.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getAllUser")
    public List<User> getAllUser() {
        return userMapper.getAll();
    }
}
