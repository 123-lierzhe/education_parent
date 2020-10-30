package com.sjzc.course.mapper;

import com.sjzc.course.entity.EduCourse;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther liez
 * @Date 17:39 2020/10/29
 */
@Mapper
public interface EduCourseMapper {
    void insertCourseAndDescription(EduCourse course);
}
