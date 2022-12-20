package com.baldcharm.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baldcharm.blog.entity.User;
import com.baldcharm.blog.mapper.UserMapperDao;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapperDao userMapperDao;

    @Override
    public User login(String username) {
        User user = userMapperDao.getUserByUsername(username);

        return user;
    }
}
