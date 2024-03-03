package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Course;
import com.softeem.iov.mapper.CourseMapper;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassService classService;
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
        //time格式为yyyy-MM-dd HH:mm:ss

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_time_start", time);
        List<Course> courses= baseMapper.selectList(queryWrapper);
        if(courses.size() != 0){
            courses.forEach(course -> {
                course.setTeacher(teacherService.getTeacherById(course.getTeacherId()));
                course.setSclass(classService.getClassById(course.getClassId()));
            });
        }
        return courses;
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
        List<Course> courses = baseMapper.selectList(queryWrapper);
        if(courses.size() != 0){
            courses.forEach(course -> {
                course.setTeacher(teacherService.getTeacherById(course.getTeacherId()));
                course.setSclass(classService.getClassById(course.getClassId()));
            });
        }
        return courses;
    }

    //获取即将开始的课程信息
    public List getCourseBySoon() {
        // 获取当前时区的当前日期和时间
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        // 定义课程时间段
        LocalTime[] courseTimes = {
                LocalTime.of(8, 0), LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0),
                LocalTime.of(14, 0), LocalTime.of(15, 0), LocalTime.of(16, 0), LocalTime.of(17, 0)
        };

        // 计算下一个课程的开始时间
        LocalTime nextCourseTime = null;
        for (LocalTime courseTime : courseTimes) {
            if (now.toLocalTime().isBefore(courseTime)) {
                nextCourseTime = courseTime;
                break;
            }
        }

        // 如果当前时间不在指定时间段内，处理逻辑
        if (nextCourseTime == null) {
            // 例如，返回空列表或查询次日课程
            return new ArrayList<>();
        }

        // 使用下一个课程时间构建查询条件
        LocalDateTime courseTimeStart = LocalDateTime.of(now.toLocalDate(), nextCourseTime);
        LocalDateTime courseTimeEnd = courseTimeStart.plusHours(1);

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("course_time_start", java.sql.Timestamp.valueOf(courseTimeStart));
        queryWrapper.ge("course_time_end", java.sql.Timestamp.valueOf(courseTimeEnd));
        List<Course> courses = baseMapper.selectList(queryWrapper);
        if(courses.size() != 0){
            courses.forEach(course -> {
                course.setTeacher(teacherService.getTeacherById(course.getTeacherId()));
                course.setSclass(classService.getClassById(course.getClassId()));
            });
        }
        return courses;
    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        return baseMapper.deleteById(courseId) > 0;
    }

    @Override
    public boolean addCourse(Course course) {
        return baseMapper.insert(course) > 0;
    }

    @Override
    public boolean updateCourse(Course course) {
        return baseMapper.updateById(course) > 0;
    }
}
