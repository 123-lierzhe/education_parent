package com.sjzc.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjzc.course.entity.EduCourse;
import com.sjzc.course.entity.EduCourseDescription;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import com.sjzc.course.entity.vo.CoursePublishVo;
import com.sjzc.course.mapper.EduCourseDescriptionMapper;
import com.sjzc.course.mapper.EduCourseMapper;
import com.sjzc.course.service.EduCourseService;
import com.sjzc.utils.GetUuid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:40 2020/10/29
 */
@Service
@Slf4j
@Transactional
public class EduCourseServiceImpl implements EduCourseService {

    @Autowired
    private EduCourseMapper courseMapper;
    @Autowired
    private EduCourseDescriptionMapper courseDescriptionMapper;

    @Override
    public String insertCourseAndDescription(CourseAndDescribeVo courseAndDescribeVo) {

        //添加课程表
        EduCourse course = new EduCourse();
        String uuid = GetUuid.uuid();
        course.setId(uuid);
        course.setGmtCreate(new Date());
        course.setGmtModified(new Date());
        BeanUtils.copyProperties(courseAndDescribeVo,course);
        log.info("获取的课程为"+course);
        courseMapper.insertCourseAndDescription(course);

        //添加课程表述表
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setId(uuid);
        courseDescription.setGmtCreate(new Date());
        courseDescription.setGmtModified(new Date());
        BeanUtils.copyProperties(courseAndDescribeVo,courseDescription);
        log.info("获取的课程描述为"+courseDescription);
        courseDescriptionMapper.insertCourseAndDescription(courseDescription);

        return uuid;
    }

    @Override
    public CourseAndDescribeVo getCourseAndDescribeByCourseId(String courseId) {
        CourseAndDescribeVo courseAndDescribeVo = courseMapper.getCourseAndDescribeByCourseId(courseId);
        return courseAndDescribeVo;
    }

    @Override
    public void updateCourseAndChapterByCourseId(CourseAndDescribeVo courseAndDescribeVo) {

        //更新课程
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseAndDescribeVo.getCourseId());
        eduCourse.setGmtModified(new Date());
        BeanUtils.copyProperties(courseAndDescribeVo,eduCourse);
        log.info("更新课程信息为"+eduCourse);
        courseMapper.updateCourse(eduCourse);

        //跟新课程描述
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseAndDescribeVo.getCourseId());
        eduCourseDescription.setGmtModified(new Date());
        BeanUtils.copyProperties(courseAndDescribeVo,eduCourseDescription);
        log.info("更新课程描述信息为"+eduCourseDescription);
        courseDescriptionMapper.update(eduCourseDescription);
    }

    @Override
    public CoursePublishVo getPublishCourse(String courseId) {
        return courseMapper.getPublishCourse(courseId);
    }

    @Override
    public void publishCourse(String courseId) {
        courseMapper.publishCourse(courseId);
    }

    @Override
    public Map<String,Object> getCoursePageByCondition(Map<String, Object> map) {

        Map<String,Object> resultMap = new HashMap<>();

        PageHelper.startPage((int)map.get("current"),(int)map.get("limit"));

        List<EduCourse> courseList = courseMapper.getCoursePageByCondition(map);

        PageInfo<EduCourse> pageInfo = new PageInfo<>(courseList);
        long total = pageInfo.getTotal();

        resultMap.put("total",total);
        resultMap.put("courseList",courseList);

        return resultMap;


    }
}
