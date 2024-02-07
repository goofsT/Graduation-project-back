package com.softeem.iov.auth.dtos;
import javax.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    public String username;
    @NotBlank(message = "密码不能为空")
    public String password;
}
