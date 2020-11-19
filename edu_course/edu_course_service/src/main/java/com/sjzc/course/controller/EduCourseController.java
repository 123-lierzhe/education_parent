package com.sjzc.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import com.sjzc.course.entity.vo.CoursePublishVo;
import com.sjzc.course.service.EduCourseService;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:37 2020/10/29
 */
@RestController
@RequestMapping("courseService/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @PostMapping("insertCourseAndDescription")
    public R insertCourseAndDescription(@RequestBody CourseAndDescribeVo courseAndDescribeVo){
        if(StringUtils.isBlank(courseAndDescribeVo.getTitle()) || StringUtils.isBlank(courseAndDescribeVo.getDescription()) ||
                StringUtils.isBlank(courseAndDescribeVo.getTeacherId()) || StringUtils.isBlank(courseAndDescribeVo.getSubjectId()) ||
                StringUtils.isBlank(courseAndDescribeVo.getSubjectParentId()) || courseAndDescribeVo.getLessonNum()==null ||
                courseAndDescribeVo.getPrice()==null || StringUtils.isBlank(courseAndDescribeVo.getCover())){
            return R.error().message("请填写所有选项");
        }
        try {
            String courseId = courseService.insertCourseAndDescription(courseAndDescribeVo);
            return R.oK().data("courseId",courseId);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("getCourseAndDescribeByCourseId")
    public R getCourseAndDescribeByCourseId(@RequestParam("courseId") String courseId){
        CourseAndDescribeVo courseAndDescribeVo = courseService.getCourseAndDescribeByCourseId(courseId);
        courseAndDescribeVo.setCourseId(courseId);
        return R.oK().data("course",courseAndDescribeVo);
    }

    @PostMapping("updateCourseAndChapterByCourseId")
    public R updateCourseAndChapterByCourseId(@RequestBody  CourseAndDescribeVo courseAndDescribeVo){
        try {
            courseService.updateCourseAndChapterByCourseId(courseAndDescribeVo);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.oK();
    }

    //课程发布页面-信息展示确认-获得页面信息
    @PostMapping("getPublishCourse/{courseId}")
    public R getPublishCourse(@PathVariable("courseId") String courseId){
        CoursePublishVo coursePublishVo = courseService.getPublishCourse(courseId);
        return R.oK().data("data",coursePublishVo);
    }

}
