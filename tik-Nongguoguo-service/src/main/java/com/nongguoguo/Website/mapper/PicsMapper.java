package com.nongguoguo.Website.mapper;

import com.nongguoguo.Website.domain.Pics;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component
public interface PicsMapper extends BaseMapper<Pics> {

    List<Pics> getPicsByGoodsId(Long goodsId);

}
