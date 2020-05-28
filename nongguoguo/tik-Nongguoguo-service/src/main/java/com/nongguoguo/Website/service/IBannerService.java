package com.nongguoguo.Website.service;

import com.nongguoguo.Website.domain.Banner;

import java.util.List;

/**
 *
 */
public interface IBannerService extends BaseService<Banner> {

    List<Banner> selectByType(String type);
}
