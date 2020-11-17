package com.sjzc.course.mapper;

import com.sjzc.course.entity.EduVideo;
import com.sjzc.course.entity.vo.VideoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther liez
 * @Date 17:55 2020/10/29
 */
@Mapper
public interface EduVideoMapper {
    List<VideoVo> getVideoByCourseId(String courseId);

    List<EduVideo> getVideoByChapterId(String chapterId);
}
