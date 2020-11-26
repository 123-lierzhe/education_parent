package com.sjzc.video.service;

import com.sjzc.utils.R;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:55 2020/11/25
 */
public interface EduVideoService {
    String uploadVideo(MultipartFile file);

    R deleteVideo(String videoId);

}
