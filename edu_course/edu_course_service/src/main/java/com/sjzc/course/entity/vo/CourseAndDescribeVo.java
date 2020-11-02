package com.sjzc.course.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther liez
 * @Date 11:05 2020/10/30
 */
@Data
public class CourseAndDescribeVo {
    private String title;

    private String description;

    private BigDecimal price;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private String cover;

    private Integer lessonNum;
}
