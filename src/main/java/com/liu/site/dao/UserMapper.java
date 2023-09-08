package com.liu.site.dao;

import com.liu.site.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Select("select * from user where id=#{id}")
    User getUserById(String id);

    @Select("select name from user where id=#{id}")
    String getUserNameById(String id);
}
