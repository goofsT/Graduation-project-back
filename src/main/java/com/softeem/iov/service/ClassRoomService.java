package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService extends IService<ClassRoom> {
    //获取教室信息
    public List getAllClassRoomInfo();

    public List<ClassRoom> getRepairClassRoom();

    //获取单个教室信息 传入教室id
    public ClassRoom getOneClass(Integer roomId);

    //更新单个教室状态
    public boolean updateOneClassRoomStatus(Integer roomId, String status);

    public boolean resetClassRoomStatus(Integer roomId);

    List getClassRoomByFloor(Integer buildingId, String floor);

    //某时段空间教室
    List <ClassRoom> getClassRoomFreeByTime(String  time);
}
