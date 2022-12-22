package com.baldcharm.blog.entity;

import java.sql.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String role;

    private Map<String, Object> createBy;

    private Date createTime;

    private Map<String, Object> updateBy;

    private Date updateTime;
}
