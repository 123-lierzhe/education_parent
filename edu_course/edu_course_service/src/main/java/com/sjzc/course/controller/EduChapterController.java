package com.sjzc.course.controller;

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
}
