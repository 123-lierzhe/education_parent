package com.sjzc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Auther liez
 * @Date 16:17 2020/10/29
 */
@Data
public class EduTeacher {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String intro;

    private String career;

    private Integer level;

    private String avatar;

    private Integer sort;

    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;
}
