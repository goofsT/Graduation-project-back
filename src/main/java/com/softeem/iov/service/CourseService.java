package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    //获取所有课程信息
    public List getAllCourseInfo();

    //获取单个课程信息 传入课程id
    public Course getOneCourse(Integer courseId);

    //获取指定时间的课程信息
    public List getCourseByTime(String time);

    public Course getCurrentCourseByRoomId(Integer roomId);

    //获取当前时间段的课程信息
    public List getCourseByNow();

    public List getCourseBySoon();

    //删除课程
    public boolean deleteCourse(Integer courseId);

    //添加课程
    public boolean addCourse(Course course);

    //修改课程信息
    public boolean updateCourse(Course course);
}
