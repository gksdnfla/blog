package com.baldcharm.blog.config;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.baldcharm.blog.entity.LoginUser;
import com.baldcharm.blog.entity.User;
import com.baldcharm.blog.filter.AuthenticationFilter;
import com.baldcharm.blog.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            // .antMatchers(
            //     "/admin",
            //     "/admin/**",
            //     "/api/admin/**"
            // )
            // .hasRole("ADMIN")
            .antMatchers(
                "/", 
                "/about", 
                "/documents", 
                "/login",
                "/api/login",
                "/js/**",
                "/css/**",
                "/images/**"
            )
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userService.login(username);
                        
                if(Objects.isNull(user)) {
                    throw new RuntimeException("No user was found");
                }

                return new LoginUser(user);
            }
        };
    }
}
