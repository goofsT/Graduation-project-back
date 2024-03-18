package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.mapper.TeacherMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    private AffairService affairService;
    @Autowired
    public void setAffairService(@Lazy AffairService affairService) {
        this.affairService = affairService;
    }
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
        Integer result = baseMapper.deleteById(teacherId);
        Teacher teacher = this.getTeacherById(teacherId);
        if(result > 0){
            Integer userId = UserUtils.getUserInfo();
            affairService.commitAffair(userId, teacher.getTeacherName()+"教师信息删除", "3", teacher.getTeacherId());
            return true;
        }
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
       Integer result = baseMapper.insert(teacher);
            if(result > 0){
                Integer userId = UserUtils.getUserInfo();
                affairService.commitAffair(userId, teacher.getTeacherName()+"教师信息添加", "3", teacher.getTeacherId());
                return true;
            }
            return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return baseMapper.updateById(teacher) > 0;
    }

    @Override
    public List<Teacher> getTeacherByText(String text) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (!text.isEmpty()) {
            queryWrapper.lambda().like(Teacher::getTeacherName, text);
        }
        return baseMapper.selectList(queryWrapper);
    }
}
