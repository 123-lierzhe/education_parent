package com.sjzc.base.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 * @Auther liez
 * @Date 10:47 2020/10/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduException extends RuntimeException {

   private ExceptionEnum exceptionEnum;
}
