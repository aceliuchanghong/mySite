package com.liu.site.mapper;

import com.liu.site.pojo.StudentOrder;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentOrderMapper {
    String selectOrderName1(String id);
    StudentOrder selectOrderName(String id);
}
