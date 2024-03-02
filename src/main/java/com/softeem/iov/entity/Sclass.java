package com.softeem.iov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Sclass implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer classId;
    private String className;
    private Integer classNum;
    private Integer class_counselor;

    private String counselorNumber;

    @Override
    public String toString() {
        return "Sclass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classNum=" + classNum +
                ", counselorNumber=" + counselorNumber +
                ", class_counselor=" + class_counselor +
                '}';
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

    public Integer getClass_counselor() {
        return class_counselor;
    }

    public void setClass_counselor(Integer class_counselor) {
        this.class_counselor = class_counselor;
    }
}
