package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.mapper.TeacherMapper;
import com.softeem.iov.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return baseMapper.selectById(teacherId);
    }
}
