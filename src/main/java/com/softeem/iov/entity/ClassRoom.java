package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class ClassRoom implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer roomId;
    private String roomName;
    private String studentNum;
    private String floorNum;
    private String buildingId;

    private String positionModel;
    private String status;
    //课程信息，数据库中没有这个字段，只是为了方便前端展示
    @TableField(exist = false)
    private Course course;

    public String getPositionModel() {
        return positionModel;
    }
    public void setPositionModel(String positionModel) {
        this.positionModel = positionModel;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "roomId='" + roomId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", course='" + course + '\'' +
                ", floorNum='" + floorNum + '\'' +
                ", positionModel='" + positionModel + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setCourse(Course course) {
        this.course=course;
    }
    public Course getCourse() {
        return course;
    }
}
