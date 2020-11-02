package com.sjzc.course.service.impl;

import com.sjzc.course.entity.EduCourse;
import com.sjzc.course.entity.EduCourseDescription;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
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
}
