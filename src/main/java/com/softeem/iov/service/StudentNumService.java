package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.StudentNum;
import com.softeem.iov.entity.User;

import java.util.List;

public interface StudentNumService extends IService<StudentNum> {
    //根据楼栋id和时间获取人数
    StudentNum getNumByBuildingId(Integer buildingId,String time);

    Boolean addStudentNumInfo(StudentNum studentNum);

    List<StudentNum> getTodayStudentNum();
}
