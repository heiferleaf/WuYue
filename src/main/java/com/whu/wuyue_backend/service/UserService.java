package com.whu.wuyue_backend.service;

import com.whu.wuyue_backend.mapper.UserMapper;
import com.whu.wuyue_backend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int userRegister(String userName, String userPassword) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);

        if(null != userMapper.getUserByName(userName)) {
            return -1;
        }

        return userMapper.userRegister(user);
    }

    public User userLogin(String userName, String userPassword) {
        return userMapper.userLogin(userName, userPassword);
    }
}
