package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Sclass;
import com.softeem.iov.mapper.SclassMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClassServiceImpl extends ServiceImpl<SclassMapper, Sclass> implements ClassService {
    @Autowired
    AffairService affairService;
    @Override
    public List<Sclass> getAllClass() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public Sclass getClassById(Integer classId) {
        return this.baseMapper.selectById(classId);
    }

    @Override
    public boolean addClass(Sclass sclass) {
        return this.baseMapper.insert(sclass) > 0;
    }

    @Override
    public boolean deleteClass(Integer classId) {
        Sclass aClass = this.getClassById(classId);
        Integer result=this.baseMapper.deleteById(classId);
        if(result>0){
            Integer userId= UserUtils.getUserInfo();
            affairService.commitAffair(userId,aClass.getClassName()+"班级数据删除","2",classId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateClass(Sclass sclass) {
       Integer result=this.baseMapper.updateById(sclass);
       if(result>0){
              Integer userId= UserUtils.getUserInfo();
                affairService.commitAffair(userId,sclass.getClassName()+"班级数据更新","2",sclass.getClassId());
           return true;
       }else{
           return false;
       }
    }


}
