package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.Course;
import com.softeem.iov.mapper.CourseMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    private TeacherService teacherService;
    private AffairService affairService;
    private ClassService classService;
    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Autowired
    public void setAffairService(AffairService affairService) {
        this.affairService = affairService;
    }
    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
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
        queryWrapper.le("course_time_start", time) // course_time_start <= time
                .gt("course_time_end", time);  // course_time_end >= time
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

    @Override
    public List getCourseByToday() {
        // 获取当前日期
        LocalDateTime now = LocalDateTime.now();
        // 获取今天的日期
        LocalDateTime today = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
        // 获取明天的日期
        LocalDateTime tomorrow = today.plusDays(1);
        // 获取今天的课程信息
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("course_time_start", java.sql.Timestamp.valueOf(tomorrow));
        queryWrapper.ge("course_time_end", java.sql.Timestamp.valueOf(today));
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
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
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
    public List getCourseByTodayNotStart() {
        // 获取当前日期时间
        LocalDateTime now = LocalDateTime.now();
        // 获取今天的日期的开始时间
        LocalDateTime today = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
        // 获取明天的日期的开始时间
        LocalDateTime tomorrow = today.plusDays(1);
        // 获取今天未开始的课程信息
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("course_time_start", java.sql.Timestamp.valueOf(now)); // 修正为大于当前时间
        queryWrapper.lt("course_time_start", java.sql.Timestamp.valueOf(tomorrow));
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
        Course c= this.getOneCourse(courseId);
        Integer result = baseMapper.deleteById(courseId);
        if(result > 0){
            Integer userId= UserUtils.getUserInfo();
            affairService.commitAffair(userId,"上课时间为"+c.getCourseTimeStart()+"的"+c.getCourseName()+"课程信息删除","4",courseId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addCourse(Course course) {
        Integer result = baseMapper.insert(course);
        if(result > 0){
            Integer userId= UserUtils.getUserInfo();
            affairService.commitAffair(userId,"上课时间为"+course.getCourseTimeStart()+"的"+course.getCourseName()+"课程信息添加","4",course.getCourseId());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateCourse(Course course) {
        Course c= this.getOneCourse(course.getCourseId());
        Integer result = baseMapper.updateById(course);
        //如果更换了教室，且有相关事务，则删除相关更新教室的事务
        if(c.getRoomId()!=course.getRoomId()){
            affairService.getAffairByTypeId(course.getCourseId()).forEach(affair -> {
                if(affair.getDescription().contains("更换教室")){
                    affairService.deleteAffairById(affair.getAffairId());
                }
            });
        }
        if(result > 0){
            Integer userId= UserUtils.getUserInfo();
            affairService.commitAffair(userId,"上课时间为"+course.getCourseTimeStart()+"的"+course.getCourseName()+"课程信息更新","4",course.getCourseId());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void updateCourseTimes() {
        baseMapper.updateCourseTimes();
    }
}
