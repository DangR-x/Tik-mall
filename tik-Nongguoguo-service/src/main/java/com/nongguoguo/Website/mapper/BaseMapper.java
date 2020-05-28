package com.nongguoguo.Website.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by J on 2020/5/22 14:13
 */
public interface BaseMapper<T> {

    void insert(T t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(T t);

    T selectById(Serializable id);

    List<T> selectAll();


}
