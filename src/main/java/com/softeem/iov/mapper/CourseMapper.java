package com.softeem.iov.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.softeem.iov.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
