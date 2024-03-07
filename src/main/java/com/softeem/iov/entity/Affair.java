package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Affair implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.AUTO)
    private Integer affairId;

    private String affairTime;

    //0 设备相关 1 教室相关  2班级相关 3教师相关 4课程相关 5权限相关
    private String affairType;

    //存储相关id
    private Integer affairTypeId;

    private String description;

    private Integer recordUserId;


    @TableField(exist = false)
    private Device device;

    @TableField(exist = false)
    private ClassRoom classRoom;

    @TableField(exist = false)
    private User recordUser;

    @TableField(exist = false)
    private Teacher teacher;

    @TableField(exist = false)
    private Course course;

    @TableField(exist = false)
    private Sclass sclass;

    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "Affair{" +
                "affairId=" + affairId +
                ", affairTime='" + affairTime + '\'' +
                ", affairType='" + affairType + '\'' +
                ", affairTypeId=" + affairTypeId +
                ", description='" + description + "'" +
                ", recordUserId=" + recordUserId +
                ", device=" + device +
                ", classRoom=" + classRoom +
                ", recordUser=" + recordUser +
                ", teacher=" + teacher +
                ", course=" + course +
                ", sclass=" + sclass +
                ", user=" + user +
                '}';
    }

   public String getAffairType() {return affairType;}

    public void setAffairType(String affairType) {this.affairType = affairType;}

    public Integer getAffairTypeId() {return affairTypeId;}

    public void setAffairTypeId(Integer affairTypeId) {this.affairTypeId = affairTypeId;}

    public Integer getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAffairId() {
        return affairId;
    }

    public void setAffairId(Integer affairId) {
        this.affairId = affairId;
    }

    public String getAffairTime() {
        return affairTime;
    }

    public void setAffairTime(String affairTime) {
        this.affairTime = affairTime;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public User getRecordUser() {
        return recordUser;
    }

    public void setRecordUser(User recordUser) {
        this.recordUser = recordUser;
    }

    public Teacher getTeacher() {return teacher;}

    public void setTeacher(Teacher teacher) {this.teacher = teacher;}

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    public Sclass getSclass() {return sclass;}

    public void setSclass(Sclass sclass) {this.sclass = sclass;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

}
