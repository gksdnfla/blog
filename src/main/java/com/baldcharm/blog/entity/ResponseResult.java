package com.baldcharm.blog.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseResult {
    public int status;
    public Object data;
    public String message;
}
