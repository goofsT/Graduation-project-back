package com.softeem.iov.controller;
import com.softeem.iov.auth.AuthenticationService;
import com.softeem.iov.auth.dtos.LoginDTO;
import com.softeem.iov.auth.dtos.RegisterDTO;
import com.softeem.iov.auth.dtos.ResetPwdDTO;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.entity.User;
import com.softeem.iov.service.IUserService;
import com.softeem.iov.utils.ResponseData;
import com.softeem.iov.utils.TokenResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseData<User> login(@Valid @RequestBody LoginDTO loginBody){
        String username= loginBody.username;
        String password=loginBody.password;
        User user=userService.login(username,password);
        //判断用户是否存在
        if(user==null){
            return ResponseData.error(400,"用户名或密码错误");
        }else{
            String token= authenticationService.generateJwtToken(user);
            user.setPassword(null);
            if(token==null){
                return ResponseData.serverError();
            }else{
                TokenResponseData tokenResponseData=new TokenResponseData(200,"success",user,token);
                System.out.println(tokenResponseData);
                return tokenResponseData;
            }
        }
    }


    @GetMapping("/getUserList")
    public ResponseData<List<User>> getAllUsers(){
        List<User> userList= userService.getUserList();
        //判断是查询失败还是查询结果为空
        if(userList==null){
            return ResponseData.error(500,"查询失败");
        }else if(userList.size()==0){
            return ResponseData.error(500,"查询结果为空");
        }
        return ResponseData.success(userList);
    }


    @RequestMapping("/getUserByText")
    public ResponseData getTeacherByText(@RequestParam String text) {
        List<User> UserList = userService.getUserByText(text);
        if (UserList != null) {
            return ResponseData.success(UserList);
        } else {
            return ResponseData.error(400, "查询失败");
        }
    }


    @PostMapping("/register")
    public ResponseData<User> register(@Valid @RequestBody RegisterDTO registerBody){
        User user=new User();
        user.setUsername(registerBody.username);
        user.setPassword(passwordEncoder.encode(registerBody.password));
        user.setRealname(registerBody.realname);
        user.setTelphone(registerBody.telphone);
        user.setCardnum(registerBody.cardnum);
        user.setPermission("1");
        String msg=userService.register(user);
        if(msg.contains("已经注册") || msg.contains("失败")){
            return ResponseData.error(400,msg);
        }else{
            return ResponseData.success(user);
        }
    }

    @PostMapping("/resetPwd")
    public ResponseData<User> register(@Valid @RequestBody ResetPwdDTO resetPwdBody){
        User user=new User();
        user.setRealname(resetPwdBody.realname);
        user.setCardnum(resetPwdBody.cardnum);
        user.setPassword(passwordEncoder.encode(resetPwdBody.newpassword));
        String msg=userService.resetPwd(user);
        if(msg=="用户不存在"||msg=="修改失败"){
            return ResponseData.error(400,msg);
        }else{
            return ResponseData.success(null);
        }
    }

    @PostMapping("/deleteUser")
    public ResponseData<User> deleteUser(@RequestBody User user){
        Boolean result=userService.deleteUser(user.getId());
        if(result){
            return ResponseData.success(null);
        }else{
            return ResponseData.error(400,"删除失败");
        }
    }

    @PostMapping("/setRole")
    public ResponseData<User> setRole(@RequestBody User user){
        Boolean result=userService.setRole(user.getId(),user.getPermission());
        if(result){
            return ResponseData.success(null);
        }else{
            return ResponseData.error(400,"设置失败");
        }
    }
}
