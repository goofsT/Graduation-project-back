package com.softeem.iov.controller;

import com.softeem.iov.service.StudentNumService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentNumController {
    @Autowired
    private StudentNumService studentNumService;
    //获取今天的人数
    @GetMapping("/getTodayStudentNum")
    public ResponseData getTodayStudentNum(){
        return ResponseData.success(studentNumService.getTodayStudentNum());
    }
}
