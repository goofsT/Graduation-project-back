package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.mapper.AffairMapper;
import com.softeem.iov.service.AffairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AffairServiceImpl extends ServiceImpl<AffairMapper, Affair> implements AffairService {
    @Override
    public Boolean commitAffair(Integer recordUserId,String description,String affairType,Integer affairTypeId) {
        Affair affair = new Affair();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = now.format(formatter);
        affair.setAffairTime(formattedCurrentTime);
        affair.setDescription(description);
        affair.setRecordUserId(recordUserId);
        affair.setAffairType(affairType);
        affair.setAffairTypeId(affairTypeId);
        Integer result=baseMapper.insert(affair);
        return result>0;
    }

    @Override
    public Affair selectAffairById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteAffairById(Integer id) {
        baseMapper.deleteById(id);
    }

}
