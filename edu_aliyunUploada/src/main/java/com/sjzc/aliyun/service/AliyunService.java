package com.sjzc.aliyun.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther liez
 * @Date 16:44 2020/10/15
 */
public interface AliyunService {
    String uploadImageToAliyun(MultipartFile file);
}
