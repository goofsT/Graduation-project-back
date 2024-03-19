package com.softeem.iov.utils;

import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Course;
import com.softeem.iov.entity.Device;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodayRepairUpdater {
    @Autowired
    private AffairService affairService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ClassRoomService classRoomService;

    @Scheduled(fixedRate = 6000) // 每分钟执行一次  定时根据课程表更新教室状态
    public void updateClassRoomStatus() {
        List<Affair> todayAffairs = affairService.getTodayAffairs();
        List<Device> repairDevices = deviceService.getAllRepairDevice();
        List<ClassRoom> repairRooms = classRoomService.getRepairClassRoom();
        if(todayAffairs.isEmpty() && todayAffairs.size()==0){
            repairDevices.forEach(device -> {
                affairService.commitAffair(1,device.getDeviceName()+"需要维修","0",device.getDeviceId());
            });
            repairRooms.forEach(room -> {
                affairService.commitAffair(1,room.getRoomName()+"需要维修","1",room.getRoomId());
            });
        }else{
            todayAffairs.forEach(affair -> {
                if(affair.getAffairType().equals("0")){
                    if(affair.getDescription().contains("需要维修")){
                        Device device=deviceService.selectDeviceById(affair.getAffairTypeId());
                        if(device.getDeviceStatus().equals("2")){
                            affairService.updateAffairTimeByNow(affair.getAffairId());
                        }else{
                            affairService.deleteAffairById(affair.getAffairId());
                        }
                    }
                }else if(affair.getAffairType().equals("1")){
                    if(affair.getDescription().contains("需要维修")) {
                        ClassRoom classRoom = classRoomService.getOneClass(affair.getAffairTypeId());
                        if (classRoom.getStatus().equals("2")) {
                            affairService.updateAffairTimeByNow(affair.getAffairId());
                        } else {
                            affairService.deleteAffairById(affair.getAffairId());
                        }
                    }
                }
            });

        }
    }
}
