package com.liu.site;


import com.liu.site.mapper.StudentMapper;
import com.liu.site.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FirstDemoTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectList() {
        List<Student> list = studentMapper.selectList(null);

        System.out.println(list);
    }
}