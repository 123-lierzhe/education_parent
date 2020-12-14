package com.sjzc.banner.service;

import com.sjzc.banner.entity.EduBanner;
import com.sjzc.utils.R;

import java.util.List;

/**
 * @Auther liez
 * @Date 15:35 2020/12/8
 */
public interface EduBannerService {
    List<EduBanner> getAllBanner();

    R getBannerPage(int page, int limit);
}
