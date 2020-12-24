package com.sjzc.service.impl;

import com.sjzc.base.exceptionHandler.EduException;
import com.sjzc.base.exceptionHandler.ExceptionEnum;
import com.sjzc.domain.UserConter;
import com.sjzc.mapper.UserConterMapper;
import com.sjzc.service.UserConterService;
import com.sjzc.utils.GetUuid;
import com.sjzc.utils.JWTUtils;
import com.sjzc.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @Auther liez
 * @Date 17:28 2020/12/22
 */
@Service
public class UserConterServiceImpl implements UserConterService {

    @Autowired
    private UserConterMapper userConterMapper;
    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

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

    @Override
    public void register(UserConter userConter) {
//        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);

//        try {
            if ((!"".equals(userConter.getMobile()) && userConter.getMobile() != null) || (!"".equals(userConter.getOpenid()) && userConter.getOpenid() != null)) {
                String password = userConter.getPassword();
                String passwordMD5 = MD5.encodeByMD5(password);
                userConter.setPassword(passwordMD5);
                userConter.setGmtCreate(new Date());
                userConter.setGmtModified(new Date());
                userConter.setId(GetUuid.uuid());
                userConterMapper.register(userConter);
            } else {
                throw new EduException(ExceptionEnum.MOBILE_CON_NOT_NULL);
            }
//            dataSourceTransactionManager.commit(transaction);
//        }catch (Exception e){
//            dataSourceTransactionManager.rollback(transaction);
//        }

    }

    @Override
    public UserConter getUserConter(String openid){
        return userConterMapper.getUserConter(openid);
    }
}
