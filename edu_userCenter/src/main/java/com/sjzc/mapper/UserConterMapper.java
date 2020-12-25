package com.sjzc.mapper;

import com.sjzc.domain.UserConter;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Auther liez
 * @Date 17:29 2020/12/22
 */
@Mapper
public interface UserConterMapper {

    UserConter login(Map<String, Object> requestMap);

    void register(UserConter userConter);

    UserConter getUserConter(String openid);

    UserConter getUserById(String userId);
}
