package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.User;
import com.softeem.iov.mapper.UserMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AffairService affairService;
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
    public User login(String username, String password) {
        //根据用户名和密码查询用户
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().eq("username", username).eq("password", password));
        return user;
    }

    @Override
    public String register(User user) {
       //判断用户是否已存在
        User user1 = this.baseMapper.selectOne(new QueryWrapper<User>().eq("cardnum",user.getCardnum()));
        if(user1!=null){
            return "用户已存在";
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
        user.setPremission(permission);
        int update = this.baseMapper.updateById(user);
        if(update>0) {
            Affair affair = new Affair();
            affair.setRecordUserId(userId);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedCurrentTime = now.format(formatter);
            affair.setAffairTime(formattedCurrentTime);
            affair.setDescription(user.getRealname()+"用户权限设置为"+this.getPermission(permission));
            affairService.commitAffair(affair);
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
