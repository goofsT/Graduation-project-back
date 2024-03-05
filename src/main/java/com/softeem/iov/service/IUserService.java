package com.softeem.iov.service;
import com.softeem.iov.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-10-09
 */

public interface IUserService extends IService<User> {
    List<User> getUserList();

    User getUserById(Integer id);

    User login(String username, String password);

    //注册
    String register(User user);

    String resetPwd(User user);

    Boolean deleteUser(Integer userId);

    Boolean setRole(Integer userId,String permission);
}
