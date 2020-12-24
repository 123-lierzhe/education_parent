package com.sjzc.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjzc.course.entity.EduCourse;
import com.sjzc.course.entity.vo.CourseAndDescribeVo;
import com.sjzc.course.entity.vo.CoursePublishVo;
import com.sjzc.course.entity.vo.SearchCourseVo;
import com.sjzc.course.service.EduCourseService;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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

    //发布课程
    @PostMapping("publishCourse/{courseId}")
    public R publishCourse(@PathVariable("courseId") String courseId){
        try {
            courseService.publishCourse(courseId);
        }catch (Exception e) {
            return R.error().message(e.getMessage());
        }
        return R.oK();
    }

    //分页获得课程信息列表以及按查询条件过滤
    @PostMapping("getCoursePageByCondition")
    public R getCoursePageByCondition(@RequestBody Map<String,Object> map){

        Map<String,Object> conditionMap = new HashMap<>();

        if(!"".equals(map.get("title")) && map.get("title") != null){
            conditionMap.put("title",map.get("title"));
        }
        if(!"".equals(map.get("status")) && map.get("status") != null){
            conditionMap.put("status",map.get("status"));
        }
        if(!"".equals(map.get("createTime")) && map.get("createTime") != null){
            conditionMap.put("createTime",map.get("createTime"));
        }
        if(!"".equals(map.get("modifyTime")) && map.get("modifyTime") != null){
            conditionMap.put("modifyTime",map.get("modifyTime"));
        }
        conditionMap.put("current",map.get("current"));
        conditionMap.put("limit",map.get("limit"));

        try {
            Map<String,Object> courseMap  = courseService.getCoursePageByCondition(map);
            return R.oK().data("data", courseMap);
        }catch (Exception e){
            e.printStackTrace();
            return R.error().message(e.getMessage());
        }
    }

    //删除课程
    @PostMapping("deleteCourse/{courseId}")
    public R deleteCourse(@PathVariable("courseId") String courseId){
        try {
            courseService.deleteCourse(courseId);
        }catch (Exception e){
            e.printStackTrace();
            return R.error();
        }
        return R.oK();
    }

    @GetMapping("getAllCourse")
    public R getAllCourse(){
        List<EduCourse> list = courseService.getAll();
        return R.oK().data("courseList",list);
    }

    /**
     *
     * @return R
     */
    @PostMapping("getCoursePageByCondition/{page}/{limit}")
    public R getCoursePageByCondition(@RequestBody(required = false) SearchCourseVo courseVo,
                                      @PathVariable("page") int page,
                                      @PathVariable("limit") int limit){

        Map<String,Object> resultMap = courseService.getCoursesPageByCondition(courseVo,page,limit);
        return R.oK().data("data",resultMap);

    }
}
