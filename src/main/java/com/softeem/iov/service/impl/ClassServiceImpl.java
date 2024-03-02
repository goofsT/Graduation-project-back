package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Sclass;
import com.softeem.iov.mapper.SclassMapper;
import com.softeem.iov.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl extends ServiceImpl<SclassMapper, Sclass> implements ClassService {
    @Override
    public List<Sclass> getAllClass() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public Sclass getClassById(Integer classId) {
        return this.baseMapper.selectById(classId);
    }


}
