package com.sjzc.banner.impl;

import com.sjzc.banner.entity.EduBanner;
import com.sjzc.banner.mapper.EduBannerMapper;
import com.sjzc.banner.service.EduBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther liez
 * @Date 15:35 2020/12/8
 */
@Service
public class EduBannerServiceImpl implements EduBannerService {

    @Autowired(required = false)
    private EduBannerMapper eduBannerMapper;

    @Override
    public List<EduBanner> getAllBanner() {
        List<EduBanner> bannerList = eduBannerMapper.getAllBanner();
        return bannerList;
    }
}
