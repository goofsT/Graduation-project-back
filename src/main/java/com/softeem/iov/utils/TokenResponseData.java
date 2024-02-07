package com.softeem.iov.utils;

import com.softeem.iov.entity.User;

public class TokenResponseData extends ResponseData<User>{
    private String token;

    public TokenResponseData(int code, String message, User data, String token) {
        super(code, message, data);
        this.token = token;

    }
    public String getToken() {
        return token;
    }
    // 如果需要，也可以提供一个setter方法
    public void setToken(String token) {
        this.token = token;
    }
}
