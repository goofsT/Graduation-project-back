package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Affair implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.AUTO)
    private Integer affairId;
    private Integer deviceId;
    private Integer roomId;
    private String affairType;
    private String affairTime;
    private String status;

    @TableField(exist = false)
    private Device device;

    @TableField(exist = false)
    private ClassRoom classRoom;

    @TableField(exist = false)
    private User recordUser;

    @Override
    public String toString() {
        return "Affair{" +
                "affairId=" + affairId +
                ", deviceId=" + deviceId +
                ", roomId=" + roomId +
                ", affairType='" + affairType + '\'' +
                ", affairTime='" + affairTime + '\'' +
                ", status='" + status + '\'' +
                ", device=" + device +
                ", classRoom=" + classRoom +
                ", recordUser=" + recordUser +
                '}';
    }

    public Integer getAffairId() {
        return affairId;
    }

    public void setAffairId(Integer affairId) {
        this.affairId = affairId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getAffairType() {
        return affairType;
    }

    public void setAffairType(String affairType) {
        this.affairType = affairType;
    }

    public String getAffairTime() {
        return affairTime;
    }

    public void setAffairTime(String affairTime) {
        this.affairTime = affairTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
