package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Course;
import com.softeem.iov.mapper.CourseMapper;
import com.softeem.iov.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Override
    public List getAllCourseInfo() {
        return baseMapper.selectList(null);
    }

    @Override
    public Course getOneCourse(Integer courseId) {
        return baseMapper.selectById(courseId);
    }

    @Override
    public List getCourseByTime(String time) {
        //根据时间，判断是否在courseTimeStart和courseTimeEnd之间，返回符合条件的课程信息
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("course_time_start", time);
        queryWrapper.ge("course_time_end", time);
        return baseMapper.selectList(queryWrapper);

    }

    @Override
    public Course getCurrentCourseByRoomId(Integer roomId) {
       List currentCourse = getCourseByNow();
         for (int i = 0; i < currentCourse.size(); i++) {
              if (((Course) currentCourse.get(i)).getRoomId().equals(roomId)) {
                return (Course) currentCourse.get(i);
              }
         }
        return null;
    }

    //获取当前时间段的课程信息
    public List getCourseByNow() {
        // 获取当前时间
        Date time = new Date();
       // 创建一个 Calendar 实例，并将其设置为当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        //根据时间，判断是否在courseTimeStart和courseTimeEnd之间，返回符合条件的课程信息
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("course_time_start", calendar.getTime());
        queryWrapper.ge("course_time_end", calendar.getTime());
        return baseMapper.selectList(queryWrapper);
    }
}
