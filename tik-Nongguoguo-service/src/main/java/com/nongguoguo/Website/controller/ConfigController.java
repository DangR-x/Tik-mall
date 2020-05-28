package com.nongguoguo.Website.controller;

import cn.hutool.core.collection.CollUtil;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @RequestMapping(value = "/values",method = RequestMethod.GET)
    public CommonResult getValues(@RequestParam String keys){

        ArrayList<Object> objects = new ArrayList<>();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("dateUpdate","2020-02-17 20:55:35");
        map.put("key","tt_vet_open");
        map.put("remark","是否开启抖音小程序审核模式");
        map.put("value","0");
        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("dateUpdate","2020-04-28 21:22:43");
        map1.put("key","mallName");
        map1.put("remark","小程序名称");
        map1.put("value","农果果");
        objects.add(map);
        objects.add(map1);
        return CommonResult.success(0,objects);

    }

    @RequestMapping(value = "/vipLevel",method = RequestMethod.GET)
    public CommonResult getVipLevel(){

        return CommonResult.success(0,2);
    }

}
