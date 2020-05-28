package com.nongguoguo.Website.mapper;

import com.nongguoguo.Website.domain.Banner;

import java.util.List;

/**
 *
 */
public interface BannerMapper extends BaseMapper<Banner> {

    List<Banner> selectByType(String type);

}
