package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Affair;

import java.util.List;

public interface AffairService extends IService<Affair> {
    //提交事务
    Boolean commitAffair(Integer recordUserId,String description,String affairType,Integer affairTypeId);

    //根据事务id查询事务
    Affair selectAffairById(Integer id);

    //根据事务id删除事务
    Boolean deleteAffairById(Integer id);

    List<Affair> getAllAffairs();

    //获取今日事务
    List<Affair> getTodayAffairs();

    //更新事务时间为当前时间
    Boolean updateAffairTimeByNow(Integer affairId);

    //获取今日关于某个类型的事务
    List<Affair> getAffairByTypeId(Integer typeId);

    //获取本周事务
    List<Affair> getAffairByWeek();

    List<Affair> getAffairByDate(String date);
}
