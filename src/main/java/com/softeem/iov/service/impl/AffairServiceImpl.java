package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.User;
import com.softeem.iov.mapper.AffairMapper;
import com.softeem.iov.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AffairServiceImpl extends ServiceImpl<AffairMapper, Affair> implements AffairService {
    private DeviceService deviceService;
    private ClassRoomService classRoomService;
    private IUserService userService;
    private TeacherService teacherService;
    private CourseService courseService;
    private ClassService classService;
    @Autowired
    public void setDeviceService(@Lazy DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    @Autowired
    public void setClassRoomService(@Lazy ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }
    @Autowired
    public void setUserService(@Lazy IUserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setTeacherService(@Lazy TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Autowired
    public void setCourseService(@Lazy CourseService courseService) {
        this.courseService = courseService;
    }
    @Autowired
    public void setClassService(@Lazy ClassService classService) {
        this.classService = classService;
    }
    @Override
    public Boolean commitAffair(Integer recordUserId,String description,String affairType,Integer affairTypeId) {
        Affair affair = new Affair();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = now.format(formatter);
        affair.setAffairTime(formattedCurrentTime);
        affair.setDescription(description);
        affair.setRecordUserId(recordUserId);
        affair.setAffairType(affairType);
        affair.setAffairTypeId(affairTypeId);
        Integer result=baseMapper.insert(affair);
        return result>0;
    }

    @Override
    public Affair selectAffairById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Boolean deleteAffairById(Integer id) {
        return baseMapper.deleteById(id)>0;
    }

    @Override
    public List<Affair> getAllAffairs() {
        List<Affair> affairList = baseMapper.selectList(null);
        if(affairList == null) {
            return null;
        } else {
            if(affairList.size() == 0) {
                return null;
            } else {
                affairList.forEach(affair -> {
                    User user = userService.getUserById(affair.getRecordUserId());
                    affair.setRecordUser(user);
                    if(affair.getAffairType().equals("0")) {
                        affair.setDevice(deviceService.selectDeviceById(affair.getAffairTypeId()));
                    } else if(affair.getAffairType().equals("1")) {
                        affair.setClassRoom(classRoomService.getOneClass(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("2")) {
                        affair.setSclass(classService.getClassById(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("3")) {
                        affair.setTeacher(teacherService.getTeacherById(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("4")) {
                        affair.setCourse(courseService.getOneCourse(affair.getAffairTypeId()));
                    }else{
                        affair.setUser(userService.getUserById(affair.getAffairTypeId()));
                    }
                });
                return affairList;
            }
        }
    }

    @Override
    public List<Affair> getTodayAffairs() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Affair> affairList = this.getAllAffairs();
        List<Affair> newList=new ArrayList<>();
        if(affairList == null) {
            return new ArrayList<>(0);
        } else {
            if(affairList.size() == 0) {
                return new ArrayList<>(0);
            } else {
                affairList.forEach(affair -> {
                    LocalDateTime dateTime = LocalDateTime.parse(affair.getAffairTime(), formatter);
                    boolean isToday = dateTime.toLocalDate().equals(today);
                    if(isToday){
                        newList.add(affair);
                    }
                });
                return newList;
            }
        }
    }

    @Override
    public Boolean updateAffairTimeByNow(Integer affairId) {
        Affair affair = baseMapper.selectById(affairId);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = now.format(formatter);
        affair.setAffairTime(formattedCurrentTime);
        Integer result=baseMapper.updateById(affair);
        return result>0;
    }

    @Override
    public List<Affair> getAffairByTypeId(Integer typeId) {
        List<Affair> affairs=this.getTodayAffairs();
        List<Affair> result=new ArrayList<>();
        for (Affair affair:affairs){
            if(affair.getAffairTypeId().equals(typeId)){
                result.add(affair);
            }
        }
        return result;
    }

    @Override
    public List<Affair> getAffairByWeek() {
        //获取本周的日期 判断事务的日期是否在本周内
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate end = now.plusDays(7 - now.getDayOfWeek().getValue());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Affair> affairList = this.getAllAffairs();
        List<Affair> newList=new ArrayList<>();
        if(affairList == null) {
            return new ArrayList<>(0);
        } else {
            if(affairList.size() == 0) {
                return new ArrayList<>(0);
            } else {
                affairList.forEach(affair -> {
                    LocalDateTime dateTime = LocalDateTime.parse(affair.getAffairTime(), formatter);
                    boolean isThisWeek = dateTime.toLocalDate().isAfter(start) && dateTime.toLocalDate().isBefore(end);
                    if(isThisWeek){
                        newList.add(affair);
                    }
                });
                return newList;
            }
        }
    }

    @Override
    public List<Affair> getAffairByDate(String date) {
       //date格式为：yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(date+" 00:00:00", formatter);
        LocalDateTime end = LocalDateTime.parse(date+" 23:59:59", formatter);
        QueryWrapper<Affair> wrapper = new QueryWrapper<>();
        wrapper.between("affair_time",start,end);
        List<Affair> affairList = baseMapper.selectList(wrapper);
        if(affairList == null) {
            return new ArrayList<>(0);
        } else {
            if(affairList.size() == 0) {
                return new ArrayList<>(0);
            } else {
                affairList.forEach(affair -> {
                    User user = userService.getUserById(affair.getRecordUserId());
                    affair.setRecordUser(user);
                    if(affair.getAffairType().equals("0")) {
                        affair.setDevice(deviceService.selectDeviceById(affair.getAffairTypeId()));
                    } else if(affair.getAffairType().equals("1")) {
                        affair.setClassRoom(classRoomService.getOneClass(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("2")) {
                        affair.setSclass(classService.getClassById(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("3")) {
                        affair.setTeacher(teacherService.getTeacherById(affair.getAffairTypeId()));
                    }else if(affair.getAffairType().equals("4")) {
                        affair.setCourse(courseService.getOneCourse(affair.getAffairTypeId()));
                    }else{
                        affair.setUser(userService.getUserById(affair.getAffairTypeId()));
                    }
                });
                return affairList;
            }
        }
    }

}
