package com.sjzc.controller;

import com.sjzc.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

/**
 * @Auther liez
 * @Date 14:21 2020/12/23
 */
@Controller
@RequestMapping("userConterService/userConter")
@CrossOrigin
public class VxLoginController {

    @Autowired
    private PropertiesUtils propertiesUtils;

    /**
     * 微信登录步骤1-获得登录二维码
     * @return
     */
    @GetMapping("getVxPhoto")
    public String getVxPhoto(){
        String appid = propertiesUtils.getAppid();
        String appsecret = propertiesUtils.getAppsecret();
        String redirecturl = propertiesUtils.getRedirecturl();

        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        try {
             redirecturl = URLEncoder.encode(redirecturl, "utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }

        String url = String.format(
                baseUrl,
                appid,
                redirecturl,
                "atguigu"
        );

        return "redirect:"+url;
    }
}
