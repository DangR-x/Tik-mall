package com.nongguoguo.Website.controller;

import com.nongguoguo.Website.domain.Banner;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import com.nongguoguo.Website.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/banner")
public class BannersController {

    @Autowired
    private IBannerService bannerService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult getbanners(@RequestParam String type){
        List<Banner> banners = bannerService.selectByType(type);


        return CommonResult.success(0,banners);
    }


}
