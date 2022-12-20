package com.baldcharm.blog.entity;

import java.sql.Date;

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

    private User createBy;

    private Date createTime;

    private User updateBy;

    private Date updateTime;
}
