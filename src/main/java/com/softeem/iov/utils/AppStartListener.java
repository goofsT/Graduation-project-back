package com.softeem.iov.utils;

import com.softeem.iov.service.CourseService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartListener {
    private  CourseService courseService;
    public AppStartListener(CourseService courseService) {
        this.courseService = courseService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void updateCourseTimesAfterStartup() {
        // 调用Service中的方法来更新课程时间
        courseService.updateCourseTimes();
    }

}
