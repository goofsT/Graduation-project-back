package com.softeem.iov.controller;
import com.softeem.iov.entity.Course;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

