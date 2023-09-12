package com.liu.site.controller;

import com.liu.site.dao.StudentMapper;
import com.liu.site.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //仅仅请求数据
public class StudentController {
    // 有问题
// https://blog.csdn.net/qq_37924905/article/details/113244602
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/student")
    public List query() {
        List<Student> list = studentMapper.selectList(null);
        System.out.println(list);
        return list;
    }




    @PostMapping("/student")
    public String save(Student student) {
        int token = studentMapper.insert(student);
        if (token > 0) return "SUC";
        else return "ERR";
    }
}
