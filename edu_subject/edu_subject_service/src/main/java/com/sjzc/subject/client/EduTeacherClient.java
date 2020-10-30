package com.sjzc.subject.client;

import com.sjzc.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther liez
 * @Date 14:21 2020/10/29
 */
@FeignClient("service-teacher")
public interface EduTeacherClient{
    @GetMapping("teacherService/teacher/findAll")
    R findAll();

    @PostMapping("teacherService/teacher/delete/{id}")
    R deleteTeacher(@PathVariable(value = "id") String id);
}
