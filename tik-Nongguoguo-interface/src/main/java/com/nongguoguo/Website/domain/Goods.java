package com.nongguoguo.Website.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  商品信息
 */
@Data
public class Goods {
    private Long id;
    //售出后
    private String afterSale;
    //商品种类分类
    private Long categoryId;
    //佣金
    private BigDecimal commission;
    //佣金类型
    private Integer commissionType;
    //商品创建时间
    private Date createtime;
    //商品修改时间
    private Date updatetime;

    private Integer fxType;
    //得到分数
    private Integer gotScore;
    //得分类型
    private Integer gotScoreType;
    //是否隐藏
    private Integer hidden;
    //是否砍价
    private boolean kanjia;
    //砍价价格
    private BigDecimal kanjiaPrice;
    //活动限制
    private boolean limitation;
    //物流
    private Long logisticsId;
    //最大优惠
    private Integer maxCoupons;
    //是否秒杀
    private boolean miaosha;
    //最少售价
    private BigDecimal minPrice;
    //最低得分
    private Integer minScore;
    //商品名称
    private String name;
    //推荐偏袒
    private Integer numberFav;
    //商品声誉
    private Integer numberGoodrequtation;
    //订单数
    private Integer numberOrders;
    //售出数量
    private Integer numberSells;
    //上线售价
    private BigDecimal originalPrice;
    //排序
    private Integer paixu;
    //图片
    private String pic;
    //是否拼团
    private boolean pingtuan;
    //拼团价格
    private BigDecimal pingtuanPrice;
    //推荐
    private Integer recommendStatus;
    //推荐描述
    private String recommendStatusstr;
    //是否售空
    private boolean sellEnd;
    //是否开售
    private boolean sellStart;
    //
    private Long shopId;
    //现状
    private Integer status;
    //现状描述
    private String statusstr;
    //是否开始商店警告
    private boolean storeAlert;
    //商店id
    private Long stores;
    //商店是否不安全
    private boolean storesUnsale;
    //商品上传人
    private Long adminId;
    //审查状态
    private Integer vetStatus;
    //商品评价
    private Long views;
    //商品重量
    private BigDecimal weight;




}
