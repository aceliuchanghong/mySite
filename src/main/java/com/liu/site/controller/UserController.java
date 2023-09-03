package com.liu.site.controller;

import com.liu.site.dao.UserMapper;
import com.liu.site.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userMapper.getAll();
    }


    @GetMapping("getAllUser2")
    public User getAllUser2(@PathVariable String id) {
        return userMapper.getUserById(id);
    }
}
