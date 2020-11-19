package com.sjzc.course.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 17:49 2020/10/29
 */
@Data
public class EduVideo {

    private String id;

    private String courseId;

    private String chapterId;

    private String title;

    private String videoSourceId;

    private String videoOriginalName;

    private Integer sort;

    private String playCount;

    private Integer isFree;

    private Float duration;

    private String status;

    private Integer size;

    private Integer version;

    private Date gmtCreate;

    private Date gmtModified;

}

