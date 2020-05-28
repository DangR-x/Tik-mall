package com.nongguoguo.Website.controller;

import com.nongguoguo.Website.domain.Category;
import com.nongguoguo.Website.domain.Pics;
import com.nongguoguo.Website.dto.GoodsParam;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import com.nongguoguo.Website.service.IPicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private IPicsService picsService;

    @RequestMapping(value = "/pics/{goodsId}",method = RequestMethod.GET)
    public CommonResult getPicsByGoodsId(@PathVariable("goodsId") Long goodsId){
        List<Pics> pics = picsService.getPicsByGoodsId(goodsId);
        GoodsParam goodsParam = new GoodsParam();
        goodsParam.setPics(pics);
        goodsParam.setCategory(new Category());
        return CommonResult.success(goodsParam);
    }

}
