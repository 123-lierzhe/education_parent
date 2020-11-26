package com.sjzc.video.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.sjzc.base.exceptionHandler.EduException;
import com.sjzc.base.exceptionHandler.ExceptionEnum;
import com.sjzc.utils.R;
import com.sjzc.video.aliyunClient.AliyunVodSDKUtils;
import com.sjzc.video.service.EduVideoService;
import com.sjzc.video.util.ConstantPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:56 2020/11/25
 */
@Service
@Slf4j
public class EduVideoServiceImpl implements EduVideoService {

    @Autowired
    private ConstantPropertiesUtil constantPropertiesUtil;

    @Override
    public String uploadVideo(MultipartFile file) {
        try {

            String keyid = constantPropertiesUtil.getKeyid();
            String keysecret = constantPropertiesUtil.getKeysecret();

            String originalFilename = file.getOriginalFilename();
            String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));

            InputStream inputStream = file.getInputStream();

            log.info("========上传视频开始========");

            UploadStreamRequest request = new UploadStreamRequest(keyid, keysecret, title, originalFilename, inputStream);

            UploadVideoImpl uploadVideo = new UploadVideoImpl();
            UploadStreamResponse response = uploadVideo.uploadStream(request);

            log.info("========上传视频完成========");

            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else {
                videoId = response.getVideoId();
            }

            return videoId;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public R deleteVideo(String videoId) {
        String keyid = constantPropertiesUtil.getKeyid();
        String keysecret = constantPropertiesUtil.getKeysecret();
        try {

            log.info("========删除视频id为"+videoId);

            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(keyid, keysecret);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);
            client.getAcsResponse(request);

            log.info("========删除id为"+videoId+"的视频成功");

            return R.oK();
        }catch (Exception e){
            e.printStackTrace();
            throw new EduException(ExceptionEnum.DELETE_VIDEO_ERROR);
        }
    }
}
