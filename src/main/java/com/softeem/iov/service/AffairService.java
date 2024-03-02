package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Affair;

public interface AffairService extends IService<Affair> {
    //提交事务
    void commitAffair(Affair affair);

    //根据事务id查询事务
    Affair selectAffairById(Integer id);

    //根据事务id删除事务
    void deleteAffairById(Integer id);

    //根据事务id修改事务状态
    void updateAffairStatusById(Integer id, String status);
}
