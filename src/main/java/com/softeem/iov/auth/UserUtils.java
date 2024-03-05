package com.softeem.iov.auth;

import com.softeem.iov.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {
    public static Integer  getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            return user.getId(); // 假设User类有getId()方法
        } else {
            throw new IllegalStateException("用户未登录或用户信息不可用");
        }
    }

}
