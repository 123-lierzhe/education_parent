package com.sjzc.base.exceptionHandler;

import lombok.Data;

import java.util.Date;

/**
 * 异常返回结果
 * @Auther liez
 * @Date 11:00 2020/10/10
 */
@Data
public class ExceptionResult {
    private Integer code;
    private String msg;
    private Long currentTime;

    public ExceptionResult(ExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.currentTime = System.currentTimeMillis();
    }

}
