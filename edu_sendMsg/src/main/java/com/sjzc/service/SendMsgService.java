package com.sjzc.service;

import java.util.Map;

/**
 * @Auther liez
 * @Date 15:52 2020/12/21
 */
public interface SendMsgService {

    boolean sendMsg(String phoneNumber,Map<String, Object> requestMap);
}
