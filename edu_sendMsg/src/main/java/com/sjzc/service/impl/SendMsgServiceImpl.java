package com.sjzc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.sjzc.service.SendMsgService;
import com.sjzc.util.ConstantPropertiesUtil;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther liez
 * @Date 15:53 2020/12/21
 */
@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Autowired
    private ConstantPropertiesUtil propertiesUtil;

    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(SendMsgServiceImpl.class);

    @Override
    public boolean sendMsg(String phoneNumber,Map<String, Object> requestMap) {

        if(StringUtils.isEmpty(phoneNumber)){
            return false;
        }

        String product = propertiesUtil.getProduct();//短信API产品名称（短信产品名固定，无需修改）
        String domain = propertiesUtil.getDomain();//短信API产品域名（接口地址固定，无需修改）
        String accessKeyId = propertiesUtil.getKeyid();//你的accessKeyId,参考本文档步骤2
        String accessKeySecret = propertiesUtil.getKeysecret();//你的accessKeySecret，参考本文档步骤2

        try {
//初始化ascClient,暂时不支持多region（请勿修改）
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //使用post提交
            request.setMethod(MethodType.POST);
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
            request.setPhoneNumbers(phoneNumber);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName("博客系统");
            //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
            request.setTemplateCode("SMS_186950967");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
//参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
            request.setTemplateParam(JSONObject.toJSONString(requestMap));
            //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");


//请求失败这里会抛ClientException异常

            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return true;
            }
            return false;
        }catch (Exception e){
            Logger.error(e.toString());
            return false;
        }
    }
}
