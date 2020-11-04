package com.sjzc.course.mapper;

import com.sjzc.course.entity.EduCourse;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:39 2020/10/29
 */
@Mapper
public interface EduCourseMapper {

    void insertCourseAndDescription(EduCourse course);

    CourseAndDescribeVo getCourseAndDescribeByCourseId(String courseId);

    void updateCourseAndChapterByCourseId(Map<String, Object> map);

    void updateCourse(EduCourse eduCourse);
}
