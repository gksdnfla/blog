package com.baldcharm.blog.restController;

import org.springframework.web.bind.annotation.RestController;

import com.baldcharm.blog.entity.LoginUser;
import com.baldcharm.blog.entity.ResponseResult;
import com.baldcharm.blog.entity.User;
import com.baldcharm.blog.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );

        if(authentication != null) {
            LoginUser user = (LoginUser)authentication.getPrincipal();
            
            user.getUser().setPassword("");

            session.setAttribute("user", user.getUser());

            return new ResponseResult(200, user.getUser(), "Login successful!");
        }

        ResponseEntity.status(400);

        return new ResponseResult(400, null, "Some erorr has occured");
    }
    
}
