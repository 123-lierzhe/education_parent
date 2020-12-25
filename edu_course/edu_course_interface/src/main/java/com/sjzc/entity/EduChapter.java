package com.sjzc.entity;

import lombok.Data;

import java.util.Date;

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

    private Date gmtCreate;

    private Date gmtModified;
}
