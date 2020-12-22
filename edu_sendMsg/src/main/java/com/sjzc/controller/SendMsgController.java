package com.sjzc.controller;

import com.sjzc.service.SendMsgService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther liez
 * @Date 15:52 2020/12/21
 */
@RestController
@RequestMapping("messageService/message")
public class SendMsgController {

    @Autowired
    private SendMsgService sendMsgService;

    //发送短信
    @PostMapping("sendMsg/{phoneNumber}")
    public R sendMsg(@PathVariable("phoneNumber") String phoneNumber){
        Map<String,Object> requestMap = new HashMap<>();
        String code = String.valueOf(new Random().nextInt(100000));
//        requestMap.put("phoneNumber",phoneNumber);
        requestMap.put("code",code);
        boolean result = sendMsgService.sendMsg(phoneNumber,requestMap);
        if(result){
            return R.oK();
        }else{
            return R.error();
        }
    }
}
