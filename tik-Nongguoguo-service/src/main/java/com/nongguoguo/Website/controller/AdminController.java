package com.nongguoguo.Website.controller;

import cn.hutool.json.JSONObject;
import com.nongguoguo.Website.config.Tikconfig;
import com.nongguoguo.Website.domain.Admin;
import com.nongguoguo.Website.domain.Menu;
import com.nongguoguo.Website.dto.AdminParam;
import com.nongguoguo.Website.dto.LoginAdminParam;
import com.nongguoguo.Website.dto.Loginparam;
import com.nongguoguo.Website.dto.UpdateAdminPasswordParam;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import com.nongguoguo.Website.service.IAdminService;
import com.nongguoguo.Website.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRoleService roleService;


    /**
     *
     * @param params
     * @return   登录用户信息
     */
    @RequestMapping(value = "/microapp/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam Map<String, String> params){

        Loginparam login = adminService.login(params);
        return CommonResult.success(0,login);
    }

    //检查登录token
    @RequestMapping(value = "/check-token",method = RequestMethod.GET)
    public CommonResult checktoken(@RequestParam String token){
        CommonResult checktoken = adminService.checktoken(token);
        if(StringUtils.isEmpty(checktoken.getData())){
            return CommonResult.failed();
        }
        return CommonResult.success(0,0);
    }

    /**
     *
     * @param token
     * @return  登录用户详细信息
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public CommonResult detail(@RequestParam String token){
        CommonResult checktoken = adminService.checktoken(token);
        Admin admin = (Admin)checktoken.getData();
        if(StringUtils.isEmpty(admin)){
            return CommonResult.failed();
        }
        HashMap<Object, Object> hashMap = new HashMap<>();
        HashMap<Object, Object> data = new HashMap<>();
        data.put("avatarUrl",admin.getAvatarUrl());
        data.put("birthdayProcessSuccessYear",0);
        data.put("cardNumber",null);
        data.put("city",null);
        data.put("dateAdd",null);
        data.put("dateLogin",null);
        data.put("id",admin.getId());
        data.put("ipAdd",null);
        data.put("ipLogin",null);
        data.put("isIdcardCheck",false);
        data.put("isSeller",false);
        data.put("levelRenew",false);
        data.put("nick",admin.getNickName());
        data.put("province","");
        data.put("source",0);
        data.put("sourceStr","头条小程序");
        data.put("status",0);
        data.put("statusStr","默认");
        data.put("taskUserLevelSendMonth","0");
        data.put("taskUserLevelSendPerMonth",false);
        hashMap.put("base",data);
        return CommonResult.success(0,hashMap);
    }

    //注册用户
    @RequestMapping(value = "/microapp/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam(required = false) String code,
                                 @RequestParam(required = false) String avatarUrl,
                                 @RequestParam(required = false) String nickName     ) {

        return adminService.tikregister(code, avatarUrl, nickName);
    }

    //获取当前登录用户信息
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        Admin admin = adminService.selectByUserName(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuByAdminId(admin.getId()));
        data.put("icon", admin.getIcon());
        return CommonResult.success(data);
    }

    //刷新token
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    //修改用户密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }
    @RequestMapping(value = "/getmenu/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenu(@PathVariable("id") Long id){
        System.out.println("menuid"+id);
        List<Menu> menus = adminService.selectMenuByAdminId(id);
        return menus;
    }

    //修改商户操作商品权限
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestParam Long adminId,
                                         @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
