package com.sjzc.base.exceptionHandler;

import com.sjzc.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 * @Auther liez
 * @Date 9:31 2020/10/10
 */
@ControllerAdvice
public class GlobleExceptionHandler {

    //全局异常处理
    //拦截特定异常，当出现该异常时，执行该方法
//    @ExceptionHandler(Exception.class)
//    //设置返回格式
//    @ResponseBody
//    public R error(Exception e){
//        e.printStackTrace();
//        return R.error().message("出错了");
//
//    }
//
//    //特定异常处理
//    //拦截特定异常，当出现该异常时，执行该方法
//    @ExceptionHandler(ArithmeticException.class)
//    //设置返回格式
//    @ResponseBody
//    public R error(ArithmeticException e){
//        e.printStackTrace();
//        return R.error().message("除数不能为0");
//
//    }

    //自定义异常处理
    //拦截特定异常，当出现该异常时，执行该方法
    @ExceptionHandler(EduException.class)
    @ResponseBody
    public ExceptionResult error(EduException e){
        return new ExceptionResult(e.getExceptionEnum());

    }

}

