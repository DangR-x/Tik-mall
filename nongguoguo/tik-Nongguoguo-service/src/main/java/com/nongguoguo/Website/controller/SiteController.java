package com.nongguoguo.Website.controller;

import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 */
@RestController
@RequestMapping("/site")
public class SiteController {

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public CommonResult getStatistics(@RequestParam(required = false) String token){

        HashMap<Object, Object> data = new HashMap<>();
        HashMap<Object, Object> dfs = new HashMap<>();
        dfs.put("capacity",61602896);
        dfs.put("capacityLeft",1073355948032L);
        dfs.put("capacityLeftStr","999.64 GB");
        dfs.put("capacityStr","58.75 MB");
        dfs.put("count",277);
        dfs.put("id",951);
        dfs.put("isFixed",true);
        data.put("dfa",dfs);
        data.put("wxAppid","wxa46b09d413fbcaff");
        data.put("wxAppAppid","wxa46b09d413fbcaff");
        HashMap<Object, Object> data3 = new HashMap<>();
        data3.put("comments",0);
        data3.put("numbers",0);
        data3.put("fav",0);
        data3.put("views",0);

        data.put("cmsArticle",data3);
        return CommonResult.success(0,data);
    }



}
