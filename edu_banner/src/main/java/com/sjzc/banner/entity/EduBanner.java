package com.sjzc.banner.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 15:43 2020/12/8
 */
@Data
public class EduBanner {
    private String id;
    private String title;
    private String imageUrl;
    private String linkUrl;
    private String sort;
    private String isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
