package com.softeem.iov.utils;

import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Course;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClassRoomStatusUpdater {

    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private  CourseService courseService;
    @Autowired
    private ClassService classService;
    @Autowired
    private AffairService affairService;

    @Autowired
    public void ClassRoomStatusScheduler(CourseService courseService, ClassRoomService classRoomService) {
        this.courseService = courseService;
        this.classRoomService = classRoomService;
    }
    @Scheduled(fixedRate = 30000) // 每分钟执行一次  定时根据课程表更新教室状态
    public void updateClassRoomStatus() {
        List<Course> coursesToUpdate = courseService.getCourseByNow();
        List<Course> todayCourses = courseService.getCourseByTodayNotStart();
        List<ClassRoom> classRooms = classRoomService.getAllClassRoomInfo();
        classRooms.forEach(room -> {
            if (!"2".equals(room.getStatus())) { // 检查教室是否不在维修状态
                classRoomService.resetClassRoomStatus(room.getRoomId());
            }else{
                //判断今天的使用教室是否有在维修的，如果有则提交维修事务
                todayCourses.forEach(course -> {
                    if (room.getRoomId().equals(course.getRoomId())) {
                        List<Affair> arrairs=affairService.getTodayAffairs();
                        Boolean flag=false;
                        for (Affair affair:arrairs){
                            //判断是否已经存在该教室的维修事务,如果存在则更新时间
                            if(affair.getAffairTypeId().equals(course.getCourseId())||affair.getDescription().contains("更换教室")){
                                affairService.updateAffairTimeByNow(affair.getAffairId());
                                flag=true;
                                break;
                            }
                        }
                        if(!flag) affairService.commitAffair(1,room.getRoomName()+"教室维修中,请更换教室,"+"课程时间："+course.getCourseTimeStart()+"课程名："+course.getCourseName(),"4",course.getCourseId());
                    }
                });

            }
        });
        if(!coursesToUpdate.isEmpty()){
            coursesToUpdate.forEach(course -> {
                classRoomService.updateOneClassRoomStatus(course.getRoomId(), "1",classService.getClassById(course.getClassId()).getClassNum()); // 更新教室状态为 "1"使用中
            });
        }
    }

}
