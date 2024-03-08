package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Sclass;

import java.util.List;

public interface ClassService extends IService<Sclass> {
    //获取所有班级
    List<Sclass> getAllClass();

    Sclass getClassById(Integer classId);

    //添加班级
    boolean addClass(Sclass sclass);

    //删除班级
    boolean deleteClass(Integer classId);

    //修改班级信息
    boolean updateClass(Sclass sclass);


}
