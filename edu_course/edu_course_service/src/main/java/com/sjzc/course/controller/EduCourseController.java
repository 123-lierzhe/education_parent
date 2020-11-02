package com.sjzc.course.controller;

import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import com.sjzc.course.service.EduCourseService;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                courseAndDescribeVo.getPrice()==null){
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

}
