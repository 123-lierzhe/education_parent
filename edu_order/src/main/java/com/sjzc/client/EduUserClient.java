package com.sjzc.client;

import com.sjzc.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther liez
 * @Date 17:08 2020/12/24
 */
@FeignClient("service-userConter")
public interface EduUserClient {

    /**
     * 通过id获得会员
     * @return
     */
    @GetMapping("userConterService/userConter/getUserById/{userId}")
    public R getUserById(@PathVariable("userId") String userId);
}
