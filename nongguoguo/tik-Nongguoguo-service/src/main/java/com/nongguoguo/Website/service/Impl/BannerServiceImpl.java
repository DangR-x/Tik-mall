package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.Banner;
import com.nongguoguo.Website.mapper.BannerMapper;
import com.nongguoguo.Website.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/27 11:35
 */
@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;



    @Override
    public void insert(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void deleteById(Serializable id) {
        bannerMapper.deleteById(id);
    }

    @Override
    public void updateById(Banner banner) {
        bannerMapper.updateById(banner);
    }

    @Override
    public Banner selectById(Serializable id) {
        return bannerMapper.selectById(id);
    }

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

    @Override
    public List<Banner> selectByType(String type) {
        return bannerMapper.selectByType(type);
    }
}
