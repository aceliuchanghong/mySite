package com.liu.site.controller;

import com.liu.site.mapper.UserMapper;
import com.liu.site.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //仅仅请求数据
@RequestMapping("userapi")
@CrossOrigin //允许跨域
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("AllUser")
    public List<User> getAllUser() {
        return userMapper.getAll();
    }

    @RequestMapping("/getUserName/{id}")
    public String getAllUser3(@PathVariable String id) {
        return userMapper.getUserNameById(id)+" 666";
    }


    // http://127.0.0.1:8888/userapi/user/1
    @GetMapping("/user/{id}")
    public User getAllUser2(@PathVariable String id) {
        return userMapper.findById(id);
    }

    @PostMapping("/user")
    public String save(User user){
        return "add user";
    }

    @PutMapping("/user")
    public String update(User user){
        return "update user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable String id){
        return "delete user by id";
    }

}
