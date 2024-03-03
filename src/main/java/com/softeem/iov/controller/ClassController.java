package com.softeem.iov.controller;

import com.softeem.iov.entity.Sclass;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    //获取所有班级信息
    @RequestMapping("/getAllClass")
    public ResponseData getAllClassInfo() {
        return ResponseData.success(classService.getAllClass());
    }

   //添加班级
    @PostMapping("/addClass")
    public ResponseData addClass(@RequestBody Sclass sclass) {
        boolean result = classService.addClass(sclass);
        if (result) {
            return ResponseData.success("添加成功");
        } else {
            return ResponseData.error(400,"添加失败");
        }
    }

    //修改班级信息
    @PostMapping("/updateClass")
    public ResponseData updateClass(@RequestBody Sclass sclass) {
        boolean result = classService.updateClass(sclass);
        if (result) {
            return ResponseData.success("修改成功");
        } else {
            return ResponseData.error(400,"修改失败");
        }
    }

    //删除班级
    @PostMapping("/deleteClass")
    public ResponseData deleteClass(@RequestBody Sclass sclass) {
        boolean result = classService.deleteClass(sclass.getClassId());
        if (result) {
            return ResponseData.success("删除成功");
        } else {
            return ResponseData.error(400,"删除失败");
        }
    }




}
