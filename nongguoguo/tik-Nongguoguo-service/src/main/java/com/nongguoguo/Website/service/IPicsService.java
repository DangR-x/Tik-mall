package com.nongguoguo.Website.service;



import com.nongguoguo.Website.domain.Pics;

import java.util.List;

/**
 *
 */
public interface IPicsService extends BaseService<Pics> {

    List<Pics> getPicsByGoodsId(Long goodsId);


}
