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
    CAN_NOT_DELETE(404,"不能删除")
    ;
    private Integer code;
    private String msg;
}
