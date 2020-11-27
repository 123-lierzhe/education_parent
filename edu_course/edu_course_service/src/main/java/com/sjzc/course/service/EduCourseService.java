package com.sjzc.course.service;

import com.sjzc.course.entity.EduCourse;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import com.sjzc.course.entity.vo.CoursePublishVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:40 2020/10/29
 */
public interface EduCourseService {

    String insertCourseAndDescription(CourseAndDescribeVo courseAndDescribeVo);

    CourseAndDescribeVo getCourseAndDescribeByCourseId(String courseId);

    void updateCourseAndChapterByCourseId(CourseAndDescribeVo courseAndDescribeVo);

    CoursePublishVo getPublishCourse(String courseId);

    void publishCourse(String courseId);

    Map<String,Object> getCoursePageByCondition(Map<String, Object> map);

    void deleteCourse(String courseId);
}
