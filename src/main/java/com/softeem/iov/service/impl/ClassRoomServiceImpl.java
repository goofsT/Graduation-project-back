package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.entity.Course;
import com.softeem.iov.entity.Device;
import com.softeem.iov.mapper.ClassRoomMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClassRoomServiceImpl extends ServiceImpl<ClassRoomMapper, ClassRoom> implements ClassRoomService {
    private CourseService courseService;
    private AffairService affairService;
    @Autowired
    public void setAffairService(@Lazy AffairService affairService) {
        this.affairService = affairService;
    }
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List getAllClassRoomInfo() {
       //先更新所有教室状态

        LambdaQueryWrapper<ClassRoom> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notLike(ClassRoom::getRoomName, "走廊");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ClassRoom> getRepairClassRoom() {
        //status=2表示设备维修中
        LambdaQueryWrapper<ClassRoom> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ClassRoom::getStatus, 2);
        queryWrapper.notLike(ClassRoom::getRoomName, "走廊");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ClassRoom getOneClass(Integer roomId) {
        return baseMapper.selectById(roomId);
    }

    //更新单个教室状态 status: 0-未使用 1-使用中 2-维修
    @Override
    public boolean updateOneClassRoomStatus(Integer roomId, String status,Integer studentNum) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setRoomId(roomId);
        classRoom.setStatus(status);
        classRoom.setStudentNum(studentNum);
        ClassRoom room=this.getOneClass(roomId);
        String oldStatus=room.getStatus();
        Integer result = baseMapper.updateById(classRoom);
        if(result > 0) {
            if(oldStatus.equals("2") && !status.equals("2")){
                Integer userId= UserUtils.getUserInfo();
                affairService.commitAffair(userId,room.getRoomName()+"教室维修完成","1",roomId);
            }
            if(status.equals("2")){
                Integer userId= UserUtils.getUserInfo();
                affairService.commitAffair(userId,room.getRoomName()+"教室需要维修","1",roomId);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean resetClassRoomStatus(Integer roomId) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setRoomId(roomId);
        classRoom.setStatus("0");
        classRoom.setStudentNum(0);
        return baseMapper.updateById(classRoom) > 0;
    }


    @Override
    public List getClassRoomByFloor(Integer buildingId, String floor) {
        LambdaQueryWrapper<ClassRoom> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ClassRoom::getBuildingId, buildingId);
        queryWrapper.eq(ClassRoom::getFloorNum, floor);
        queryWrapper.notLike(ClassRoom::getRoomName, "走廊");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<ClassRoom> getClassRoomFreeByTime(String time) {
        //获取当前时间段的课程信息
        List<Course> courses = courseService.getCourseByTime(time);
        //获取所有教室信息
        List<ClassRoom> classRooms = getAllClassRoomInfo();
        //获取当前时间段的教室信息
        if(courses.size()!=0){
            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < classRooms.size(); j++) {
                    if (courses.get(i).getRoomId().equals(classRooms.get(j).getRoomId())) {
                        classRooms.remove(j);
                    }
                }
            }
            classRooms.forEach(classRoom -> {
                if(classRoom.getStatus().equals("2")) {
                    classRooms.remove(classRoom);
                }
            });
        }
        return classRooms;
    }


}
