package com.sjzc.course.controller;

import com.sjzc.course.entity.EduChapter;
import com.sjzc.course.entity.vo.ChapterVo;
import com.sjzc.course.service.EduChapterService;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther liez
 * @Date 17:44 2020/10/29
 */
@RestController
@RequestMapping("chapterService/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    @GetMapping("getCourseAndVideo")
    public R getChapterAndVideoByCourseId(@RequestParam("courseId") String courseId){
        if(StringUtils.isBlank(courseId)){
            return R.error().message("请输入课程id");
        }
        List<ChapterVo> chapterList = chapterService.getChapterAndVideoByCourseId(courseId);
        if(CollectionUtils.isEmpty(chapterList)){
            return R.error().message("未查询到任何章节内容");
        }
        return R.oK().data("chapterList",chapterList);
    }

    //添加章节
    @PostMapping("insertChapter")
    public R insertChapter(@RequestBody EduChapter chapter){
        chapterService.insertChapter(chapter);
        return R.oK();
    }

    //根据id查询章节
    @GetMapping("getById/{chapterId}")
    public R getById(@PathVariable("chapterId") String chapterId){
        EduChapter chapter = chapterService.getById(chapterId);
        return R.oK().data("data",chapter);
    }

    //修改章节
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter chapter){
        try {
            chapterService.updateChapter(chapter);
        }catch (Exception e){
            e.printStackTrace();
            return R.error().message("修改章节失败").data("exception",e);
        }
        return R.oK();
    }

    //删除章节
    @PostMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable("chapterId") String chapterId) {
        boolean result = chapterService.deleteChapter(chapterId);
        if (result) {
            return R.oK();
        } else {
            return R.error();
        }
    }
}


