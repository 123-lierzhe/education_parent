package com.sjzc.course.entity;

import lombok.Data;

/**
 * @Auther liez
 * @Date 17:41 2020/10/29
 */
@Data
public class EduChapter {

    private String id;

    private String courseId;

    private String title;

    private String sort;

    private String gmtCreate;

    private String gmtModified;
}
