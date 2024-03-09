package com.softeem.iov.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softeem.iov.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Update("UPDATE course SET course_time_start = CONCAT(DATE(NOW()), ' ', TIME(course_time_start)), course_time_end = CONCAT(DATE(NOW()), ' ', TIME(course_time_end))")
    void updateCourseTimes();
}
