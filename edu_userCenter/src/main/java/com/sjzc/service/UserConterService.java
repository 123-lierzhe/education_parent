package com.sjzc.service;

import com.sjzc.domain.UserConter;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:28 2020/12/22
 */
public interface UserConterService {

    String login(Map<String, Object> requestMap);

    void register(UserConter userConter);

    UserConter getUserConter(String openid);

    UserConter getUserById(String userId);
}
