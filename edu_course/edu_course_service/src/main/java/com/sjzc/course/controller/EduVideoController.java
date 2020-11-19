package com.sjzc.course.controller;

import com.sjzc.course.entity.EduVideo;
import com.sjzc.course.service.EduVideoService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther liez
 * @Date 17:54 2020/10/29
 */
@RestController
@RequestMapping("videoService/video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    //添加小结
    @PostMapping("insertVideo")
    public R insertVideo(@RequestBody EduVideo video){
        try {
            videoService.insertChapter(video);
        }catch (Exception e){
            e.printStackTrace();
            return R.error().message(e.getMessage());
        }
        return R.oK();
    }

    //删除小结
    @PostMapping("deleteVideo/{videoId}")
    public R deleteChapter(@PathVariable("videoId") String videoId){
        try {
            videoService.deleteVideo(videoId);
        }catch(Exception e){
            e.printStackTrace();
            return R.error().message(e.getMessage());
        }
        return R.oK();
    }

    //更新小结
    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo video){
        try {
            videoService.updateVideo(video);
        }catch (Exception e){
            e.printStackTrace();
            return R.error().message(e.getMessage());
        }
        return R.oK();
    }
}
