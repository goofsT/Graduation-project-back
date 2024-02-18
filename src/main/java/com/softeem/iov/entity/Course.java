package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer courseId;
    private String courseName;
    private String courseTimeStart;
    private String courseTimeEnd;
    private Integer classId;
    private Integer teacherId;
    private Integer roomId;

    @TableField(exist = false)
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTimeStart() {
        return courseTimeStart;
    }

    public void setCourseTimeStart(String courseTimeStart) {
        this.courseTimeStart = courseTimeStart;
    }

    public String getCourseTimeEnd() {
        return courseTimeEnd;
    }

    public void setCourseTimeEnd(String courseTimeEnd) {
        this.courseTimeEnd = courseTimeEnd;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }



    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTimeStart='" + courseTimeStart + '\'' +
                ", courseTimeEnd='" + courseTimeEnd + '\'' +
                ", classId=" + classId +
                ", teacher" + teacher +
                ", teacherId=" + teacherId +
                ", roomId=" + roomId +
                '}';
    }
}
