package com.softeem.iov.controller;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.service.TeacherService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getTeacherById")
    public ResponseData getTeacherById(Integer teacherId) {
        return ResponseData.success(teacherService.getTeacherById(teacherId));
    }

    @RequestMapping("/getAllTeacher")
    public ResponseData getAllTeacher() {
        return ResponseData.success(teacherService.getAllTeacher());
    }

    @PostMapping("/addTeacher")
    public ResponseData addTeacher(@RequestBody Teacher teacher) {
        return ResponseData.success(teacherService.addTeacher(teacher));
    }

    @PostMapping("/updateTeacher")
    public ResponseData updateTeacher(@RequestBody Teacher teacher) {
        return ResponseData.success(teacherService.updateTeacher(teacher));
    }

    @PostMapping("/deleteTeacher")
    public ResponseData deleteTeacher(@RequestBody  Teacher teacher) {
        return ResponseData.success(teacherService.deleteTeacher(teacher.getTeacherId()));
    }
}
