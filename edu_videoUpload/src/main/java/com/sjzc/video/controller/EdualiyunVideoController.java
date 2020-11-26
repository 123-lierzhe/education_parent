package com.sjzc.video.controller;

import com.sjzc.utils.R;
import com.sjzc.video.service.EduVideoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Path;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:55 2020/11/25
 */
@RestController
@RequestMapping("aliyunVideo/video")
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
