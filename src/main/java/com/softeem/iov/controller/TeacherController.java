package com.softeem.iov.controller;
import com.mysql.cj.jdbc.BlobFromLocator;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.service.TeacherService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getTeacherById")
    public ResponseData getTeacherById(@RequestParam Integer teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            return ResponseData.success(teacher);
        } else {
            return ResponseData.error(400, "查询失败");
        }
    }

    @RequestMapping("/getAllTeacher")
    public ResponseData getAllTeacher() {
         List<Teacher> teacherList = teacherService.getAllTeacher();
        if (teacherList != null) {
            return ResponseData.success(teacherList);
        } else {
            return ResponseData.error(400, "查询失败");
        }
    }

    @PostMapping("/addTeacher")
    public ResponseData addTeacher(@RequestBody Teacher teacher) {
        if(teacher.getTeacherName() == null || teacher.getTeacherName().equals("")){
            return ResponseData.error(400, "教师姓名不能为空");
        }
        Boolean result = teacherService.addTeacher(teacher);
        if (result) {
            return ResponseData.success("添加成功");
        } else {
            return ResponseData.error(400, "添加失败");
        }
    }

    @PostMapping("/updateTeacher")
    public ResponseData updateTeacher(@RequestBody Teacher teacher) {
        if(teacher.getTeacherId()==null){
            return ResponseData.error(400, "教师ID不能为空");
        }
        Boolean result = teacherService.updateTeacher(teacher);
        if (result) {
            return ResponseData.success("修改成功");
        } else {
            return ResponseData.error(400, "修改失败");
        }
    }

    @PostMapping("/deleteTeacher")
    public ResponseData deleteTeacher(@RequestBody  Teacher teacher) {
        if(teacher.getTeacherId()==null){
            return ResponseData.error(400, "教师ID不能为空");
        }
        Boolean result = teacherService.deleteTeacher(teacher.getTeacherId());
        if (result) {
            return ResponseData.success("删除成功");
        } else {
            return ResponseData.error(400, "删除失败");
        }
    }
}
