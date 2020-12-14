package com.sjzc.banner.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjzc.banner.entity.EduBanner;
import com.sjzc.banner.mapper.EduBannerMapper;
import com.sjzc.banner.service.EduBannerService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther liez
 * @Date 15:35 2020/12/8
 */
@Service
public class EduBannerServiceImpl implements EduBannerService {

    @Autowired
    private EduBannerMapper eduBannerMapper;

    @Override
    public List<EduBanner> getAllBanner() {
        List<EduBanner> bannerList = eduBannerMapper.getAllBanner();
        return bannerList;
    }

    @Override
    public R getBannerPage(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<EduBanner> allBanner = eduBannerMapper.getAllBanner();
        PageInfo<EduBanner> info = new PageInfo<>(allBanner);
        long total = info.getTotal();
        List<EduBanner> list = info.getList();
        return R.oK().data("data",list).data("total",total);
    }


}
