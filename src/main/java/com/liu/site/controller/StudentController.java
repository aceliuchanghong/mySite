package com.liu.site.controller;

import com.liu.site.mapper.StudentMapper;
import com.liu.site.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    // http://127.0.0.1:8888/student
    @GetMapping ("/student")
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
