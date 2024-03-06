package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Affair;

public interface AffairService extends IService<Affair> {
    //提交事务
    Boolean commitAffair(Integer recordUserId,String description,String affairType,Integer affairTypeId);

    //根据事务id查询事务
    Affair selectAffairById(Integer id);

    //根据事务id删除事务
    void deleteAffairById(Integer id);

}
