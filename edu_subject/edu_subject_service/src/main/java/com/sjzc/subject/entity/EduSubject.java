package com.sjzc.subject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Auther liez
 * @Date 11:11 2020/10/20
 */
@Data
public class EduSubject {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String title;

    private String parentId;

    private Integer sort;

    private Date gmtCreate;

    private Date gmtModified;

}
