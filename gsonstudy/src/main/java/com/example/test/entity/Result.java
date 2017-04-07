package com.example.test.entity;

/**
 * author: sundong
 * created at 2017/4/7 11:32
 */
public class Result<T> {
    public int errorCode;
    public String errorMsg;
    public T data;
}
