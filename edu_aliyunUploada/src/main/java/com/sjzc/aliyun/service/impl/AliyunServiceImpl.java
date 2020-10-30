package com.sjzc.aliyun.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.sjzc.aliyun.service.AliyunService;
import com.sjzc.aliyun.utils.AliyunProperties;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther liez
 * @Date 16:44 2020/10/15
 */
@Slf4j
@Service
public class AliyunServiceImpl implements AliyunService {

    @Autowired
    private AliyunProperties properties;

    @Override
    public String uploadImageToAliyun(MultipartFile file) {

        String bucketname = properties.getBucketname();
        String endpoint = properties.getEndpoint();
        String accessKeyId = properties.getKeyid();
        String accessKeySecret = properties.getKeysecret();

        try{
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String s = UUID.randomUUID().toString();
            originalFilename = s+originalFilename;
            String date = new DateTime().toString("yyyy/MM/dd");
            String path = "eduImage"+"/"+date+"/"+originalFilename;
            ossClient.putObject(bucketname, path, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            String url = "https://"+bucketname+"."+ endpoint+ "/" +path;
            return url;

        }catch (Exception e){
            e.printStackTrace();
            return null;

        }

    }
}
