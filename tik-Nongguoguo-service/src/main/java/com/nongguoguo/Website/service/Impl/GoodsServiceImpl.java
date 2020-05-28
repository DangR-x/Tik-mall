package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.Goods;
import com.nongguoguo.Website.mapper.GoodsMapper;
import com.nongguoguo.Website.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void insert(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void deleteById(Serializable id) {
        goodsMapper.deleteById(id);
    }

    @Override
    public void updateById(Goods goods) {
        goodsMapper.updateById(goods);
    }

    @Override
    public Goods selectById(Serializable id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }
}
