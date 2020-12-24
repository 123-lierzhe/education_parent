package com.sjzc.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjzc.domain.UserConter;
import com.sjzc.service.UserConterService;
import com.sjzc.util.PropertiesUtils;
import com.sjzc.utils.GetUuid;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther liez
 * @Date 14:21 2020/12/23
 */
@Controller
@RequestMapping("api/ucenter/wx")
@CrossOrigin
public class VxLoginController {

    @Autowired
    private PropertiesUtils propertiesUtils;
    @Autowired
    private UserConterService userConterService;

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

    /**
     * 登陆人扫描调用该方法获得登陆人信息
     * @return
     */
    @ResponseBody
    @GetMapping("callback")
    public Map<String,Object> callback(String code, String state){
        /*String baseUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=%s" +
                "&secret=%s" +
                "&code=%s" +
                "&grant_type=authorization_code";
        String redirectUrl = String.format(
                baseUrl,
                propertiesUtils.getAppid(),
                propertiesUtils.getAppsecret(),
                code
        );*/
        Map<String,Object> resultMap = new HashMap<>();

        try {
            //获得令牌和open I的
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            StringBuffer params = new StringBuffer();
            params.append("appid="+propertiesUtils.getAppid());
            params.append("&");
            params.append("secret="+propertiesUtils.getAppsecret());
            params.append("&");
            params.append("code="+code);
            params.append("&");
            params.append("grant_type=authorization_code");

            HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/sns/oauth2/access_token" + "?" + params);

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            JSONObject responseJson = JSONObject.parseObject(responseString);

            UserConter conter = userConterService.getUserConter(String.valueOf(responseJson.get("openid")));

            //如果数据库中已经有该微信的openid。则直接查数据库，否则进行微信接口调用，并进行添加
            if(conter != null){
                resultMap.put("data",conter);
                return resultMap;
            }else{

                //获得用户个人信息

                String access_token = String.valueOf(responseJson.get("access_token"));
                String openid = String.valueOf(responseJson.get("openid"));

                StringBuffer anotherParams = new StringBuffer();
                anotherParams.append("access_token="+access_token);
                anotherParams.append("&");
                anotherParams.append("openid="+openid);
                anotherParams.append("&");
                anotherParams.append("lang=zh_CN");

                HttpGet anotherHttpGet = new HttpGet("https://api.weixin.qq.com/sns/userinfo" + "?" +anotherParams);

                CloseableHttpResponse anotherHttpResponse = httpClient.execute(anotherHttpGet);
                HttpEntity entity = anotherHttpResponse.getEntity();
                String anotherResponseString = EntityUtils.toString(entity);

                JSONObject responseJsonObject = JSONObject.parseObject(anotherResponseString);
                String country = String.valueOf(responseJsonObject.get("country"));
                String province = String.valueOf(responseJsonObject.get("province"));
                String city = String.valueOf(responseJsonObject.get("city"));
                String nickname = String.valueOf(responseJsonObject.get("nickname"));
                String headimgurl = String.valueOf(responseJsonObject.get("headimgurl"));

                country = new String(country.getBytes("ISO-8859-1"), "UTF-8");
                province = new String(province.getBytes("ISO-8859-1"), "UTF-8");
                city = new String(city.getBytes("ISO-8859-1"), "UTF-8");
                nickname = new String(nickname.getBytes("ISO-8859-1"), "UTF-8");

                responseJsonObject.replace("country",responseJsonObject.get("country"),country);
                responseJsonObject.replace("province",responseJsonObject.get("province"),province);
                responseJsonObject.replace("city",responseJsonObject.get("city"),city);
                responseJsonObject.replace("nickname",responseJsonObject.get("nickname"),nickname);
                resultMap.put("data",responseJsonObject);

                UserConter userConter = new UserConter();
                userConter.setId(GetUuid.uuid());
                userConter.setOpenid(openid);
                userConter.setAvatar(headimgurl);
                userConter.setNickname(nickname);

                userConterService.register(userConter);

                return resultMap;
            }
        }catch (Exception e){

        }
        return resultMap;
    }
}
