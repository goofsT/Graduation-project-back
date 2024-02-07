package com.softeem.iov.auth.dtos;

import javax.validation.constraints.NotBlank;

public class ResetPwdDTO {
    @NotBlank(message = "真实姓名不能为空")
    public String realname;
    @NotBlank(message = "身份证号不能为空")
    public String cardnum;
    @NotBlank(message = "新密码不能为空")
    public String newpassword;
}
