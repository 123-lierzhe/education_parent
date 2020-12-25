package com.sjzc.controller;

import com.sjzc.service.EduPayLogService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther liez
 * @Date 11:13 2020/12/25
 */
@RestController
@RequestMapping("payService/pay")
public class EduPayLogController {

    @Autowired
    private EduPayLogService payLogService;

    /**
     * 生成微信支付的二维码
     * @return
     */
    @GetMapping("createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo){
        Map<String,Object> resultMap = payLogService.createNative(orderNo);
        return R.oK().data("data",resultMap);
    }
}
