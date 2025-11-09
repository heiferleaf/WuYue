package com.whu.wuyue_backend.mapper;

import com.whu.wuyue_backend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper{
    public int userRegister(User user);
    public User userLogin(@Param("username") String username,  @Param("password") String password);
    public User getUserByName(@Param("username") String username);
}
