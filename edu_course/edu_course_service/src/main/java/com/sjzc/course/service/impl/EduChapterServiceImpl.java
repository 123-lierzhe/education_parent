package com.sjzc.course.service.impl;

import com.sjzc.course.entity.EduChapter;
import com.sjzc.course.entity.vo.ChapterVo;
import com.sjzc.course.entity.vo.VideoVo;
import com.sjzc.course.mapper.EduChapterMapper;
import com.sjzc.course.mapper.EduVideoMapper;
import com.sjzc.course.service.EduChapterService;
import com.sjzc.utils.GetUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther liez
 * @Date 17:46 2020/10/29
 */
@Service
public class EduChapterServiceImpl implements EduChapterService {

    @Autowired
    private EduChapterMapper chapterMapper;
    @Autowired
    private EduVideoMapper videoMapper;

    @Override
    public List<ChapterVo> getChapterAndVideoByCourseId(String courseId) {

        //查询章节
        List<ChapterVo> chapterVoList = chapterMapper.getChapterByCourseId(courseId);

        //查询小结
        List<VideoVo> videoVoList = videoMapper.getVideoByCourseId(courseId);

        for (ChapterVo chapterVo : chapterVoList) {
            List<VideoVo> list = new ArrayList<>();
            String chapterId = chapterVo.getId();
            for (VideoVo videoVo : videoVoList) {
                String chapterId1 = videoVo.getChapterId();
                if(chapterId.equals(chapterId1)){
                    list.add(videoVo);
                    chapterVo.setVideoList(list);
                }
            }
        }
        return chapterVoList;
    }

    @Override
    public void insertChapter(EduChapter chapter) {
        chapter.setId(GetUuid.uuid());
        chapter.setGmtCreate(new Date());
        chapter.setGmtModified(new Date());
        chapterMapper.inseertChapter(chapter);
    }
}
