package com.nongguoguo.Website.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class Admin {

    private Long id;
    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loginTime;
    private Integer status;
    private String openid;
    //头像
    private String avatarUrl;

}
