package com.softeem.iov.controller;
import com.softeem.iov.entity.Sclass;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class SclassController {
    @Autowired
    private ClassService classService;
    //获取所有班级
    @GetMapping("/getAllClass")
    public ResponseData<List<Sclass>> getAllClass(){
        List<Sclass> classes= classService.getAllClass();
        return ResponseData.success(classes);
    }

}
