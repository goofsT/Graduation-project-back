package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Device;
import com.softeem.iov.entity.StudentNum;
import com.softeem.iov.mapper.DeviceMapper;
import com.softeem.iov.mapper.StudentNumMapper;
import com.softeem.iov.service.DeviceService;
import com.softeem.iov.service.StudentNumService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentNumServiceImpl extends ServiceImpl<StudentNumMapper, StudentNum> implements StudentNumService {
    @Override
    public StudentNum getNumByBuildingId(Integer buildingId, String time) {
        QueryWrapper  q= new QueryWrapper<>();
        q.eq("building_id",buildingId);
        q.eq("time",time);
        return baseMapper.selectOne(q);
    }

    @Override
    public Boolean addStudentNumInfo(StudentNum studentNum) {
        return baseMapper.insert(studentNum) > 0;
    }

    @Override
    public List<StudentNum> getTodayStudentNum() {
        List<StudentNum> numList=new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        QueryWrapper q = new QueryWrapper();
        q.like("time",formattedNow.substring(0,10));
        numList=baseMapper.selectList(q);
        return numList;
    }
}
