package com.sjzc.controller;

import com.sjzc.service.UserConterService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:25 2020/12/22
 */
@RestController
@RequestMapping("userConterService/userConter")
public class UserConterController {

    @Autowired
    private UserConterService userConterService;

    /**
     * 登录
     * @param requestMap
     * @return
     */
    @PostMapping("user/login")
    public R login(@RequestBody Map<String,Object> requestMap){
        if("".equals(requestMap.get("phone")) && requestMap.get("phone") == null){
            return R.error().message("请填写手机号");
        }
        if("".equals(requestMap.get("password")) && requestMap.get("password") == null){
            return R.error().message("请填写密码");
        }
        String token = userConterService.login(requestMap);
        return R.oK().data("token",token);
    }
}
