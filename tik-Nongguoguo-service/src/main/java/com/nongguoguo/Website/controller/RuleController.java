package com.nongguoguo.Website.controller;

import com.nongguoguo.Website.domain.Rule;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by J on 2020/5/26 11:11
 */
@RestController
@RequestMapping("/score")
public class RuleController {


    @RequestMapping(value = "/send/rule",method = RequestMethod.POST)
    public CommonResult getRule(@RequestBody String code){
        //System.out.println(code);
        Rule rule = new Rule();
        rule.setCode(code);
        return CommonResult.success(0,rule);
    }


}
