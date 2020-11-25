package com.sjzc.course.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther liez
 * @Date 17:20 2020/10/29
 */
@Data
public class EduCourse {

    private String id;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private Integer buyCount;

    private Integer viewCount;

    private Integer version;

    private String status;

    private Date gmtCreate;

    private Date gmtModified;

}
