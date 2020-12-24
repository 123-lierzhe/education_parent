package com.sjzc.base.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 异常的枚举类型
 * @Auther liez
 * @Date 10:58 2020/10/10
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    TEACHER_IS_NOT_FOUND(404,"未查询到教师"),
    SUBJECTLIST_IS_NOT_FOUND(404,"为查询到分类"),
    CAN_NOT_DELETE(404,"不能删除"),
    DELETE_VIDEO_ERROR(500,"删除视频失败"),
    CAN_NOT_FIND_USER(404,"未查询到用户"),
    MOBILE_CON_NOT_NULL(404,"手机号和微信openid不能同时为空")

    ;
    private Integer code;
    private String msg;
}
