package com.softeem.iov.utils;

import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.StudentNum;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.StudentNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * 根据教室人数更新学生人数
 * 每小时更新一次 将每个教学楼的人数更新到数据库
 */
@Component
public class StudentNumUpdater {

    @Autowired
    private StudentNumService studentNumService;
    @Autowired
    private ClassRoomService classRoomService;
    @Scheduled(cron = "0 0 8,9,10,11,12,14,15,16,17,18 * * ?")
//    @Scheduled(fixedRate = 30000) // 每分钟执行一次  定时根据课程表更新教室状态
    public void updateStudentNum() {
        List<ClassRoom> rooms=classRoomService.getAllClassRoomInfo();
        StudentNum studentNumBuilding1=new StudentNum();
        StudentNum studentNumBuilding2=new StudentNum();
        Integer NumBuilding1=0;
        Integer NumBuilding2=0;
        for (ClassRoom room:rooms){
            if(Objects.equals(room.getBuildingId(), "1")){
                NumBuilding1+=room.getStudentNum();
            }else{
                NumBuilding2+=room.getStudentNum();
            }
        }
        studentNumBuilding1.setNum(NumBuilding1);
        studentNumBuilding2.setNum(NumBuilding2);
        studentNumBuilding1.setBuildingId(1);
        studentNumBuilding2.setBuildingId(2);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        studentNumBuilding1.setTime(formattedNow);
        studentNumBuilding2.setTime(formattedNow);
        studentNumService.addStudentNumInfo(studentNumBuilding1);
        studentNumService.addStudentNumInfo(studentNumBuilding2);
    }
}
