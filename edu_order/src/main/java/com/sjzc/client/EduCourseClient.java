package com.sjzc.client;

import com.sjzc.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther liez
 * @Date 16:51 2020/12/24
 */
@FeignClient("service-course")
public interface EduCourseClient {

    @PostMapping("courseService/course/getPublishCourse/{courseId}")
    R getPublishCourse(@PathVariable("courseId") String courseId);
}
