package com.sjzc.teacher.service;

import com.sjzc.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sjzc.teacher.vo.TeacherQuery;
import com.sjzc.utils.R;

import java.util.List;

/**
 * @author liez
 * @since 2020-10-09
 */
public interface EduTeacherService {

    List<EduTeacher> findAll();

    int deleteTeacher(String id);

    R findTeacherByPage(long current, long limit);

    R findTeacherByPageAndCondition(long current, long limit, TeacherQuery teacherQuery);

    int insertTeacher(EduTeacher eduTeacher);

    EduTeacher getById(String id);

    int update(EduTeacher teacher);
}
