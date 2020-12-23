package com.sjzc.service.impl;

import com.sjzc.base.exceptionHandler.EduException;
import com.sjzc.base.exceptionHandler.ExceptionEnum;
import com.sjzc.domain.UserConter;
import com.sjzc.mapper.UserConterMapper;
import com.sjzc.service.UserConterService;
import com.sjzc.utils.JWTUtils;
import com.sjzc.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:28 2020/12/22
 */
@Service
public class UserConterServiceImpl implements UserConterService {

    @Autowired
    private UserConterMapper userConterMapper;

    @Override
    public String login(Map<String, Object> requestMap) {

        requestMap.replace("password",requestMap.get("password"), MD5.encodeByMD5((String) requestMap.get("password")));
        UserConter userConter = userConterMapper.login(requestMap);
        if(userConter == null){
            throw new EduException(ExceptionEnum.CAN_NOT_FIND_USER);
        }
        String mobile = userConter.getMobile();
        String nickname = userConter.getNickname();

        String token = JWTUtils.getJwtToken(mobile, nickname);
        return token;
    }
}
