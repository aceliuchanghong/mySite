package com.liu.site.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentOrderMapper {
    String selectOrderName1(String id);
}
