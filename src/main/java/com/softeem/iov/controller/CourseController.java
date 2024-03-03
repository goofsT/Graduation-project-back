package com.softeem.iov.controller;
import com.softeem.iov.entity.Course;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/getCurrentCourse")
    public ResponseData getCurrentCourse() {
        List<Course> courses= courseService.getCourseByNow();
        return ResponseData.success(courses);
    }

    @RequestMapping("/getCourseBySoon")
    public ResponseData getCourseBySoon() {
        List<Course> courses= courseService.getCourseBySoon();
        return ResponseData.success(courses);
    }

    @PostMapping("/deleteCourse")
    public ResponseData deleteCourse(@RequestBody Course course) {
        boolean result = courseService.deleteCourse(course.getCourseId());
        if (result) {
            return ResponseData.success("删除成功");
        } else {
            return ResponseData.error(400,"删除失败");
        }
    }

    @PostMapping("/addCourse")
    public ResponseData addCourse(@RequestBody Course course) {
        boolean result = courseService.addCourse(course);
        if (result) {
            return ResponseData.success("添加成功");
        } else {
            return ResponseData.error(400,"添加失败");
        }
    }

    @PostMapping("/updateCourse")
    public ResponseData updateCourse(@RequestBody Course course) {
        boolean result = courseService.updateCourse(course);
        if (result) {
            return ResponseData.success("修改成功");
        } else {
            return ResponseData.error(400,"修改失败");
        }
    }

    @RequestMapping("/getCourseByTime")
    public ResponseData getCourseByTime(@RequestParam String time) {
        List<Course> courses= courseService.getCourseByTime(time);
        return ResponseData.success(courses);
    }
}

