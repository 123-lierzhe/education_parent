package com.sjzc.course.service;

import com.sjzc.course.entity.vo.CourseAndDescribeVo;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:40 2020/10/29
 */
public interface EduCourseService {

    String insertCourseAndDescription(CourseAndDescribeVo courseAndDescribeVo);

    CourseAndDescribeVo getCourseAndDescribeByCourseId(String courseId);

    void updateCourseAndChapterByCourseId(CourseAndDescribeVo courseAndDescribeVo);
}
