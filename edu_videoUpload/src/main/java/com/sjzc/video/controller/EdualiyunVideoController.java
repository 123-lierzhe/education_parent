package com.sjzc.video.controller;

import com.sjzc.utils.R;
import com.sjzc.video.service.EduVideoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Path;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:55 2020/11/25
 */
@RestController
@CrossOrigin
@RequestMapping("aliyunService/video")
public class EdualiyunVideoController {

    @Autowired
    private EduVideoService videoService;

    //上传视频
    @PostMapping("uploadVideo")
    public R uploadVideo(MultipartFile file){
        String videoId = videoService.uploadVideo(file);
        if(StringUtils.isNotBlank(videoId)){
            return R.oK().data("videoId",videoId);
        }else{
            return R.error();
        }
    }

    //删除视频
    @PostMapping("deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable("videoId") String videoId){
        return videoService.deleteVideo(videoId);
    }
}
