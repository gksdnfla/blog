package com.baldcharm.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baldcharm.blog.entity.User;
import com.baldcharm.blog.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username) {
        User user = userMapper.getUserByUsername(username);

        return user;
    }
}
