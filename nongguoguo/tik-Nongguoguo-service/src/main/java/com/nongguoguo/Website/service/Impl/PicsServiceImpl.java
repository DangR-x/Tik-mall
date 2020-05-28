package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.Pics;
import com.nongguoguo.Website.mapper.PicsMapper;
import com.nongguoguo.Website.service.IPicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
public class PicsServiceImpl implements IPicsService {
    @Autowired
    private PicsMapper picsMapper;

    @Override
    public void insert(Pics pics) {
        picsMapper.insert(pics);
    }

    @Override
    public void deleteById(Serializable id) {
        picsMapper.deleteById(id);
    }

    @Override
    public void updateById(Pics pics) {
        picsMapper.updateById(pics);
    }

    @Override
    public Pics selectById(Serializable id) {
        return picsMapper.selectById(id);
    }

    @Override
    public List<Pics> selectAll() {
        return picsMapper.selectAll();
    }


    @Override
    public List<Pics> getPicsByGoodsId(Long goodsId) {
        return picsMapper.getPicsByGoodsId(goodsId);
    }
}
