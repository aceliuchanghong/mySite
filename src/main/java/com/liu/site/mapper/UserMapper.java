package com.liu.site.mapper;

import com.liu.site.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();

    @Select("select name from user where id=#{id}")
    String getUserNameById(String id);


    @Insert("insert into user values(#{id},#{name})")
    int add(String id,String name);
    @Update("update user set name=#{name} where id=#{id}")
    int update(String id,String name);
    @Delete("delete from user where id=#{id}")
    int delete(String id);
    @Select("select * from user where id=#{id}")
    User findById(String id);

}
