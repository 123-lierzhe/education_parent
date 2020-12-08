package com.sjzc.banner.controller;

import com.sjzc.banner.entity.EduBanner;
import com.sjzc.banner.service.EduBannerService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 15:33 2020/12/8
 */
@RestController
@RequestMapping("bannerService/banner")
@CrossOrigin
public class EduBannerController {

    @Autowired
    private EduBannerService bannerService;

    //获得所有banner
    @GetMapping("getAllBanner")
    public R getAllBanner(){
        List<EduBanner> bannerList = bannerService.getAllBanner();
        return R.oK().data("data",bannerList);
    }
}
