package com.sjzc.course.service;

import com.sjzc.course.entity.EduVideo;

/**
 * @Auther liez
 * @Date 17:56 2020/10/29
 */
public interface EduVideoService {
    void insertChapter(EduVideo video);

    void deleteVideo(String videoId);

    void updateVideo(EduVideo video);
}
