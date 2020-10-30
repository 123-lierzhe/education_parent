package com.sjzc.teacher.api;

import com.sjzc.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther liez
 * @Date 14:18 2020/10/29
 */
public interface EduTeacherApi {

    @GetMapping("getTeacherById/{id}")
    public R getById(@PathVariable("id") String id);
}
