package com.sjzc.course.service;

import com.sjzc.course.entity.EduChapter;
import com.sjzc.course.entity.vo.ChapterVo;

import java.util.List;

/**
 * @Auther liez
 * @Date 17:46 2020/10/29
 */
public interface EduChapterService {
    List<ChapterVo> getChapterAndVideoByCourseId(String courseId);

    void insertChapter(EduChapter chapter);

    boolean deleteChapter(String chapterId);

    EduChapter getById(String chapterId);

    void updateChapter(EduChapter chapter);
}
