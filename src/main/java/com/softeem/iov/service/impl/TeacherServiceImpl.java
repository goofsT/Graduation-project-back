package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.mapper.TeacherMapper;
import com.softeem.iov.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return baseMapper.selectById(teacherId);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return baseMapper.selectList(null);
    }

    @Override
    public boolean deleteTeacher(Integer teacherId) {
        return baseMapper.deleteById(teacherId) > 0;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return baseMapper.insert(teacher) > 0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return baseMapper.updateById(teacher) > 0;
    }
}
