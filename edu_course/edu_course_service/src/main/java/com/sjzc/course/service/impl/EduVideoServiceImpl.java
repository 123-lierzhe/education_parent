package com.sjzc.course.service.impl;

import com.sjzc.course.client.AliyunVideoClient;
import com.sjzc.course.entity.EduVideo;
import com.sjzc.course.mapper.EduVideoMapper;
import com.sjzc.course.service.EduVideoService;
import com.sjzc.utils.GetUuid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther liez
 * @Date 17:56 2020/10/29
 */
@Service
public class EduVideoServiceImpl implements EduVideoService {

    @Autowired
    private EduVideoMapper videoMapper;
    @Autowired
    private AliyunVideoClient aliyunVideoClient;

    @Override
    public void insertChapter(EduVideo video) {
        video.setId(GetUuid.uuid());
        video.setGmtCreate(new Date());
        video.setGmtModified(new Date());
        videoMapper.insertVideo(video);
    }

    @Override
    public void deleteVideo(String videoId) {
        EduVideo video = videoMapper.getVideoById(videoId);
        String videoSourceId = video.getVideoSourceId();
        if(StringUtils.isNotBlank(videoSourceId)){
            aliyunVideoClient.deleteVideo(videoSourceId);
        }
        videoMapper.deleteVideo(videoId);
    }

    @Override
    public void updateVideo(EduVideo video) {
        video.setGmtModified(new Date());
        videoMapper.updateVideo(video);
    }
}
