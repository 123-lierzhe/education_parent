package com.sjzc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 11:27 2020/10/30
 */
@Data
public class EduCourseDescription {

    private String id;

    private String description;

    private Date gmtCreate;

    private Date gmtModified;
}
