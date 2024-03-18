package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Teacher;

import java.util.List;

public interface TeacherService extends IService<Teacher> {
    Teacher getTeacherById(Integer teacherId);

    List<Teacher> getAllTeacher();

    boolean deleteTeacher(Integer teacherId);

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> getTeacherByText(String text);
}
