package com.nongguoguo.Website.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class Banner {

    private Long id;
    private Integer businessId;
    private Date dateAdd;
    private Date dateUpdate;
    private Integer paixu;
    private String picUrl;
    private Integer status;
    private String statusStr;
    private String title;
    private String type;
    private Long userId;

}
