package com.softeem.iov.mapper;

import com.softeem.iov.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-10-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
