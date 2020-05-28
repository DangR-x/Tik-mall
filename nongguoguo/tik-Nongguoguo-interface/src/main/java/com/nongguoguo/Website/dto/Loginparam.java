package com.nongguoguo.Website.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
@Data
public class Loginparam {
    //登录时获取的字节官方uid
    private Long uid;
    //
    private String openid;
    //生成的token
    private String token;


}
