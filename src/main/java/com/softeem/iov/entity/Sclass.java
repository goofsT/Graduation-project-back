package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Sclass implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer classId;
    private String className;
    private Integer classNum;
    private String classCounselor;

    private String counselorNumber;

    private String academy;

    @Override
    public String toString() {
        return "Sclass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classNum=" + classNum +
                ", counselorNumber=" + counselorNumber +
                ", classCounselor=" + classCounselor +
                ", academy=" + academy +
                '}';
    }

    public String getAcademy() {
        return academy;
    }
    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getCounselorNumber() {
        return counselorNumber;
    }
    public void setCounselorNumber(String counselorNumber) {
        this.counselorNumber = counselorNumber;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public String getClassCounselor() {
        return classCounselor;
    }

    public void setClassCounselor(String classCounselor) {
        this.classCounselor = classCounselor;
    }
}
