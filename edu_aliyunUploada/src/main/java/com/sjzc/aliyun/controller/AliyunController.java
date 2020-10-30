package com.sjzc.aliyun.controller;

import com.sjzc.aliyun.service.AliyunService;
import com.sjzc.aliyun.utils.AliyunProperties;
import com.sjzc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther liez
 * @Date 16:43 2020/10/15
 */
@RestController
@RequestMapping("uploadService/aliyun")
@CrossOrigin
@Slf4j
public class AliyunController {

    @Autowired
    private AliyunService aliyunService;

    @PostMapping("uploadImageToAliyun")
    public R uploadImageToAliyun(@RequestParam(value = "file") MultipartFile file){
        String url = aliyunService.uploadImageToAliyun(file);
        if(!StringUtils.isEmpty(url)){
            log.info("图片上传成功，地址为："+url);
            return R.oK().data("url",url);
        }else{
            return R.error();
        }
    }


}
