package com.sjzc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 16:27 2020/12/24
 */
@Data
public class Order {

    private String id;
    private String orderNo;
    private String courseId;
    private String courseTitle;
    private String courseCover;
    private String teacherName;
    private String memberId;
    private String nickname;
    private String mobile;
    private Double totalFee;
    private int payType;
    private int status;
    private int isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
