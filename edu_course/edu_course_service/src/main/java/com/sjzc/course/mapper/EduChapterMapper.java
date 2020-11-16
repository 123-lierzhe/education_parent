package com.sjzc.course.mapper;

import com.sjzc.course.entity.EduChapter;
import com.sjzc.course.entity.vo.ChapterVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther liez
 * @Date 17:46 2020/10/29
 */
@Mapper
public interface EduChapterMapper {
    List<ChapterVo> getChapterByCourseId(String courseId);

    void inseertChapter(EduChapter chapter);
}
