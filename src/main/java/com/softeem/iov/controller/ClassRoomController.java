package com.softeem.iov.controller;

import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Course;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.service.TeacherService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    //获取所有教室信息
    @RequestMapping("/getClassRoom")
    public ResponseData getClassRoom() {
        List rooms= classRoomService.getAllClassRoomInfo();
        return ResponseData.success(rooms);
    }

    //获取维修中的教室
    @RequestMapping("/getRepairClassRoom")
    public ResponseData getRepairClassRoom() {
        List rooms= classRoomService.getRepairClassRoom();
        return ResponseData.success(rooms);
    }

    //获取单个教室信息
    @RequestMapping("/getOneClassRoom")
    public ResponseData getOneClassRoom(Integer roomId) {
        return ResponseData.success(classRoomService.getOneClass(roomId));
    }

    //获取某一层的教室
    @RequestMapping("/getClassRoomByFloor")
    public ResponseData getClassRoomByFloor(Integer building, String floor) {
        //如果教室的status=1表示正在使用中
        List rooms = classRoomService.getClassRoomByFloor(building, floor);
        //查询状态为1的教室的课程信息
        for (int i = 0; i < rooms.size(); i++) {
           if (((ClassRoom) rooms.get(i)).getStatus().equals("1")) {
               Course course = courseService.getCurrentCourseByRoomId(((ClassRoom) rooms.get(i)).getRoomId());
               if(course==null){
                   continue;
               }
               Teacher teacher = teacherService.getTeacherById(course.getTeacherId());
               course.setTeacher(teacher);
               ((ClassRoom) rooms.get(i)).setCourse(course);
           }
        }
        return ResponseData.success(rooms);
    }



}
