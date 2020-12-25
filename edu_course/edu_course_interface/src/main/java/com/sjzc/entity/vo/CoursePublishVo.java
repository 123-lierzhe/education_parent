package com.sjzc.entity.vo;

import lombok.Data;

/**
 * @Auther liez
 * @Date 14:58 2020/11/19
 */
@Data
public class CoursePublishVo {

    private String id;

    private String title;

    private String cover;

    private Integer lessonNum;

    private String description;

    private String subjectLevelOne;

    private String subjectLevelTwo;

    private String teacherName;

    private String price;//只用于显示
}
