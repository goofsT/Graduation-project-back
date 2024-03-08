package com.softeem.iov.controller;

import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Course;
import com.softeem.iov.entity.Sclass;
import com.softeem.iov.entity.Teacher;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.ClassService;
import com.softeem.iov.service.CourseService;
import com.softeem.iov.service.TeacherService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassService classService;
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

    @GetMapping("/getClassRoomById")
    public ResponseData getClassRoomById(@RequestParam Integer roomId) {
        ClassRoom classRoom = classRoomService.getOneClass(roomId);
        if(classRoom!=null) {
            return ResponseData.success(classRoom);
        }else{
            return ResponseData.error(400,"未查询到教室");
        }
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
               Sclass sclass = classService.getClassById(course.getClassId());
               Teacher teacher = teacherService.getTeacherById(course.getTeacherId());
               course.setTeacher(teacher);
               course.setSclass(sclass);
               ((ClassRoom) rooms.get(i)).setCourse(course);
           }
        }
        return ResponseData.success(rooms);
    }

    @PostMapping("/updateClassRoomStatus")
    public ResponseData updateClassRoomStatus(@RequestBody ClassRoom classRoom) {
        Boolean res = classRoomService.updateOneClassRoomStatus(classRoom.getRoomId(), classRoom.getStatus(), classRoom.getStudentNum());
        if (res) {
            return ResponseData.success(null);
        } else {
            return ResponseData.error(400, "设置失败");
        }
    }

    @RequestMapping("/getClassRoomFreeByTime")
    public ResponseData getClassRoomFreeByTime(@RequestParam String time) {
        List<ClassRoom> classRooms = classRoomService.getClassRoomFreeByTime(time);
        return ResponseData.success(classRooms);
    }

    @GetMapping("/getRoomNumInfo")
    public ResponseData<Object> getRoomNumInfo(){
        //返回教室总数和正在使用的教室数量
        List<ClassRoom> rooms = classRoomService.getAllClassRoomInfo();
        List<ClassRoom> freeRooms = classRoomService.getRoomIsUse();
        Object result = new Object(){
            public Integer roomNum = rooms.size();
            public Integer freeRoomNum = freeRooms.size();
        };
        return ResponseData.success(result);
    }

    @GetMapping("/getRoomSoonCourse")
    public ResponseData getRoomSoonCourse(@RequestParam Integer roomId){
        Course course = classRoomService.getRoomSoonCourse(roomId);
        if(course!=null){
            return ResponseData.success(course);
        }else{
            return ResponseData.error(400,"未查询到课程");
        }
    }


}
