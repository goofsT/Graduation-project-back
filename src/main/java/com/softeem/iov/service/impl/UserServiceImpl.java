package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.User;
import com.softeem.iov.mapper.UserMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private AffairService affairService;
    @Autowired
    public void setAffairService(AffairService affairService) {
        this.affairService = affairService;
    }
    @Override
    public List<User> getUserList() {
        List<User> userList = this.baseMapper.selectList(null);
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public User getUserByUserName(String username) {
        return this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public User getUserByCardNum(String cardNum) {
        return this.baseMapper.selectOne(new QueryWrapper<User>().eq("cardnum", cardNum));
    }

    @Override
    public User login(String username, String password) {
        //根据用户名和密码查询用户
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if(user!=null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean flag = passwordEncoder.matches(password, user.getPassword());
            if(flag){
                return user;
            }else{
                return null;
            }
        }
        return null;

    }

    @Override
    public String register(User user) {
       //判断用户是否已存在
        User user1 = this.baseMapper.selectOne(new QueryWrapper<User>().eq("cardnum",user.getCardnum()));
        User user2 = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username",user.getUsername()));
        if(user1!=null){
            return "身份证已经注册";
        }
        if(user2!=null){
            return "用户名已经注册";
        }
        //插入用户
        int insert = this.baseMapper.insert(user);
        if(insert>0){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }

    @Override
    public String resetPwd(User user) {
       User user1=this.baseMapper.selectOne(new QueryWrapper<User>().eq("cardnum",user.getCardnum()));
       if(user1==null){
            return "用户不存在";
       }else{
           user1.setPassword(user.getPassword());
           user1.setRealname(user.getRealname());
           int update = this.baseMapper.update(user1, new QueryWrapper<User>().eq("cardnum", user.getCardnum()));
           if(update>0){
               return "修改成功";
           }else{
               return "修改失败";
           }
       }
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        Integer result = this.baseMapper.deleteById(userId);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Boolean setRole(Integer userId, String permission) {
        User user = this.baseMapper.selectById(userId);
        user.setPermission(permission);
        int update = this.baseMapper.updateById(user);
        if(update>0) {
            Integer userId1 = UserUtils.getUserInfo();
            affairService.commitAffair(userId1, user.getRealname() + "用户权限更新", "5", user.getId());
            return true;
        }else{
            return false;
        }
    }

    public String getPermission(String per){
        if(per.equals("0"))
            return "管理员";
        else if(per.equals("1"))
            return "普通用户";
        else
            return "维修人员";
    }
}
