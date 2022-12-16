package com.baldcharm.blog.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.baldcharm.blog.entity.LoginUser;
import com.baldcharm.blog.entity.User;
import com.baldcharm.blog.mapper.UserMapperDao;

public class UserDetailsServiceImpl implements UserDetailsService {
    private UserMapperDao userMapperDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapperDao.getUserByUsername(username);
        
        if(Objects.isNull(user)) {
            throw new RuntimeException("아이디 혹은 비번이 틀렸습니다.");
        }

        return new LoginUser(user);
    }
    
}
