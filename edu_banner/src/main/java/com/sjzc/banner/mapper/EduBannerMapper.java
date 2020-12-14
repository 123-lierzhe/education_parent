package com.sjzc.banner.mapper;

import com.sjzc.banner.entity.EduBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther liez
 * @Date 15:36 2020/12/8
 */
@Mapper
public interface EduBannerMapper {
    List<EduBanner> getAllBanner();
}
