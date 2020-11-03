package com.sjzc.course.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther liez
 * @Date 15:42 2020/11/2
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> videoList = new ArrayList<>();

}
