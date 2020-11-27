package com.sjzc.course.client;

import com.sjzc.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther liez
 * @Date 11:11 2020/11/27
 */
@FeignClient("service-video")
public interface AliyunVideoClient {
    //删除视频
    @PostMapping("aliyunService/video/deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable("videoId") String videoId);
}

