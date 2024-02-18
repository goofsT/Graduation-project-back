package com.softeem.iov.utils;

import com.softeem.iov.entity.Course;
import com.softeem.iov.service.ClassRoomService;
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
    public void ClassRoomStatusScheduler(CourseService courseService, ClassRoomService classRoomService) {
        this.courseService = courseService;
        this.classRoomService = classRoomService;
    }

    @Scheduled(fixedRate = 60000) // 每分钟执行一次  定时根据课程表更新教室状态
    public void updateClassRoomStatus() {
        List<Course> coursesToUpdate = courseService.getCourseByNow();
        coursesToUpdate.forEach(course -> {
            // 更新教室状态为 "1"使用中
            classRoomService.updateOneClassRoomStatus(course.getRoomId(), "1");
        });
    }

}
