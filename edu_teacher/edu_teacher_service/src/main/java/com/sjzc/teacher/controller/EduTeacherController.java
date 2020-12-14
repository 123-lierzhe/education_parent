package com.sjzc.teacher.controller;


import com.sjzc.base.exceptionHandler.EduException;
import com.sjzc.base.exceptionHandler.ExceptionEnum;
import com.sjzc.teacher.entity.EduTeacher;
import com.sjzc.teacher.service.EduTeacherService;
import com.sjzc.teacher.vo.TeacherQuery;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liez
 * @since 2020-10-09
 */
@RestController
@RequestMapping("teacherService/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    //获得所有教师
    @GetMapping("findAll")
    public R findAll(){
        List<EduTeacher> teacherList = teacherService.findAll();
        if(CollectionUtils.isEmpty(teacherList)){
            throw new EduException(ExceptionEnum.TEACHER_IS_NOT_FOUND);
        }
        return R.oK().data("teacherList", teacherList);

    }

    //删除教师
    @PostMapping("delete/{id}")
    public R deleteTeacher(@PathVariable("id") String id){
        int i = teacherService.deleteTeacher(id);
        if(i==0){
            return R.error();
        }else{
            return R.oK();
        }
    }

    //分页
    @GetMapping("findTeacherByPage/{current}/{limit}")
    public R findTeacherByPage(@PathVariable("current") long current,
                               @PathVariable("limit") long limit){
        return teacherService.findTeacherByPage(current,limit);
    }

    //分页并过滤
    @PostMapping("findTeacherByPageAndCondition/{current}/{limit}")
    public R findTeacherByPageAndCondition(@PathVariable("current") long current,
                                           @PathVariable("limit") long limit,
                                           @RequestBody(required = false)TeacherQuery teacherQuery){
        R r = teacherService.findTeacherByPageAndCondition(current, limit, teacherQuery);
        return r;

    }


    //添加教师
    @PostMapping("insertTeacher")
    public R insertTeacher(@RequestBody EduTeacher eduTeacher){
        int i = teacherService.insertTeacher(eduTeacher);
        if(i==0){
            return R.error();
        }else{
            return R.oK();
        }
    }

    //查询某一教师
    @GetMapping("getTeacherById/{id}")
    public R getById(@PathVariable("id") String id){
        EduTeacher teacher = teacherService.getById(id);
        return R.oK().data("teacher",teacher);
    }

    //更新教师
    @PostMapping("update")
    public R update(@RequestBody EduTeacher teacher){
        int i = teacherService.update(teacher);
        if(i==0){
            return R.error();
        }else{
            return R.oK();
        }
    }
}
