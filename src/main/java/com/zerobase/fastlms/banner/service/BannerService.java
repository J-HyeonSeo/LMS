package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;

import java.util.List;

public interface BannerService {

    List<BannerDto> list(BannerParam parameter);

    List<BannerDto> getBanners();

    BannerDto getById(long id);

    boolean add(BannerInput parameter);

    boolean set(BannerInput parameter);

    boolean del(String idList);
}
