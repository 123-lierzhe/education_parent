package com.sjzc.controller;

import com.sjzc.domain.UserConter;
import com.sjzc.service.UserConterService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 注册
     * @return
     */
    @PostMapping("register")
    public R register(@RequestBody UserConter userConter){
        try {
            userConterService.register(userConter);
            return R.oK().message("注册成功");
        }catch (Exception e){
            return R.error().message("注册失败");
        }
    }

    /**
     * 通过id获得会员
     * @return
     */
    @GetMapping("getUserById/{userId}")
    public R getUserById(@PathVariable("userId") String userId){
        UserConter userConter = userConterService.getUserById(userId);
        return R.oK().data("data",userConter);
    }
}
