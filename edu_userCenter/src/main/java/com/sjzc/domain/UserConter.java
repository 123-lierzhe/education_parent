package com.sjzc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 17:45 2020/12/22
 */
@Data
public class UserConter {

    private String id;
    private String openid;
    private String mobile;
    private String password;
    private String nickname;
    private Boolean sex;
    private int age;
    private String avatar;
    private String sign;
    private Boolean isDisabled;
    private Boolean isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
