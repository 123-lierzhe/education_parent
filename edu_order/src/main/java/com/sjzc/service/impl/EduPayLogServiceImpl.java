package com.sjzc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;
import com.sjzc.domain.Order;
import com.sjzc.mapper.EduOrderMapper;
import com.sjzc.service.EduPayLogService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther liez
 * @Date 11:18 2020/12/25
 */
@Service
public class EduPayLogServiceImpl implements EduPayLogService {

    @Autowired
    private EduOrderMapper orderMapper;

    @Override
    public Map<String, Object> createNative(String orderNo) {
        try {

            Order order = orderMapper.getOrderById(orderNo);

            JSONObject requestMap = new JSONObject();

            //1、设置支付参数
            requestMap.put("appid", "wx74862e0dfcf69954");
            requestMap.put("mch_id", "1558950191");
            requestMap.put("nonce_str", WXPayUtil.generateNonceStr());
            requestMap.put("body", order.getCourseTitle());
            requestMap.put("out_trade_no", orderNo);
            requestMap.put("total_fee", String.valueOf(order.getTotalFee()));
            requestMap.put("spbill_create_ip", "127.0.0.1");
            requestMap.put("notify_url", "http://guli.shop/api/order/weixinPay/weixinNotify\n");
            requestMap.put("trade_type", "NATIVE");

            //2、HTTPClient来根据URL访问第三方接口并且传递参数
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/native");
            String jsonStrinRequest = JSON.toJSONString(requestMap);


            StringEntity jsonRequest = new StringEntity(jsonStrinRequest,"utf-8");
            httpPost.setHeader("Content-type","application/json");
            httpPost.setEntity(jsonRequest);

            CloseableHttpResponse response = null;
            response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            String url = EntityUtils.toString(entity,"utf-8");


            Map<String,Object> reallyResultMap = new HashMap<>();
            reallyResultMap.put("orderNo",orderNo);
            reallyResultMap.put("url",url);

            return reallyResultMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
