package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Teacher;

public interface TeacherService extends IService<Teacher> {
    Teacher getTeacherById(Integer teacherId);
}
