package com.sjzc.teacher.controller;

import com.sjzc.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther liez
 * @Date 16:07 2020/10/13
 */
@RestController
@RequestMapping("eduService/user")
@CrossOrigin
public class RegisterController {

    @PostMapping("login")
    public R login(){
        return R.oK().data("token","admin");
    }

    @GetMapping("info")
    public R getInfo(){
        return R.oK().data("roles","[admin]").data("name","liez").data("avatar","\n" +
                "https://edu-lierzhe.oss-cn-beijing.aliyuncs.com/123.jpg");
    }
}
