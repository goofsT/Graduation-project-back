package com.softeem.iov.auth.dtos;

import javax.validation.constraints.NotBlank;

public class RegisterDTO {
    @NotBlank(message = "用户名不能为空")
    public String username;

    @NotBlank(message = "密码不能为空")
    public String password;

    @NotBlank(message = "真实姓名不能为空")
    public String  realname;

    @NotBlank(message = "电话不能为空")
    public String telphone;

    @NotBlank(message = "身份证不能为空")
    public String cardnum;
}
