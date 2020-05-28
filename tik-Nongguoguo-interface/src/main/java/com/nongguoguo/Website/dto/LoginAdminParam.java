package com.nongguoguo.Website.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *      tik小程序注册返回信息
 */
@Data
public class LoginAdminParam {

    private String username;
    private String password;
    //认证code
    private String code;
    //头像地址
    private String avatarUrl;
    //别名
    private String nickName;
    //用户省份
    private String province;
    //城市
    private String city;
    //
    private String referrer;
    //登录时获取的字节官方uid
    private Long uid;
    //
    private String openid;
    //生成的token
    private String token;
}
