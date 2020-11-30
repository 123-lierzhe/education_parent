package com.sjzc.course.client;

import com.sjzc.utils.R;
import org.springframework.stereotype.Component;

/**
 * @Auther liez
 * @Date 14:52 2020/11/30
 */
@Component
public class VideoDangerFeignClient implements AliyunVideoClient{

    @Override
    public R deleteVideo(String videoId) {
        return R.error().message("熔断器执行。。。删除视频失败");
    }
}
