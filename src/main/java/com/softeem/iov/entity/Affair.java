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

    private String description;

    private Integer recordUserId;


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
                ", affairTime='" + affairTime + '\'' +
                ", description='" + description + "'" +
                ", recordUserId=" + recordUserId +
                ", device=" + device +
                ", classRoom=" + classRoom +
                ", recordUser=" + recordUser +
                '}';
    }

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
}
