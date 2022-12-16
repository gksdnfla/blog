package com.baldcharm.blog.restController;

import org.springframework.web.bind.annotation.RestController;

import com.baldcharm.blog.entity.LoginUser;
import com.baldcharm.blog.entity.ResponseResult;
import com.baldcharm.blog.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class LoginRestController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/api/login")
    public ResponseResult postMethodName(String username, String password, HttpSession session) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        LoginUser result = (LoginUser) userDetailsService.loadUserByUsername(username);

        result.getUser().setPassword("");

        if(result != null) {
            session.setAttribute("user", result.getUser());

            return new ResponseResult(200, result.getUser(), "Login successful!");
        }

        ResponseEntity.status(400);

        return new ResponseResult(400, result, "Some erorr has occured");
    }
    
}
