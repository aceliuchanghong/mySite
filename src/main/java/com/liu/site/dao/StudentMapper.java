package com.liu.site.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.site.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    //int insert(Student student);
}
