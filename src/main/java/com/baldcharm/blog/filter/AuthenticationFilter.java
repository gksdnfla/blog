package com.baldcharm.blog.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.baldcharm.blog.entity.User;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");

        if(Objects.isNull(user)) {
            filterChain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(user, null, null)
        );

        filterChain.doFilter(request, response);
    }
}
