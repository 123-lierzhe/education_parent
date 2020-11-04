package com.sjzc.course.mapper;

import com.sjzc.course.entity.EduCourseDescription;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther liez
 * @Date 11:29 2020/10/30
 */
@Mapper
public interface EduCourseDescriptionMapper {

    void insertCourseAndDescription(EduCourseDescription courseDescription);

    void update(EduCourseDescription eduCourseDescription);
}
