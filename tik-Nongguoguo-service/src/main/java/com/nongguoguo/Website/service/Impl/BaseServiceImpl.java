package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.mapper.BaseMapper;
import com.nongguoguo.Website.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/22 14:21
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateById(T t) {
        baseMapper.updateById(t);
    }

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }
}
