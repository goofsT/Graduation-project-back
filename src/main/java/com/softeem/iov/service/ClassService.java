package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Sclass;

import java.util.List;

public interface ClassService extends IService<Sclass> {
    //获取所有班级
    List<Sclass> getAllClass();

}
