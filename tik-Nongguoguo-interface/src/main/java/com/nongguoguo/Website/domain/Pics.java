package com.nongguoguo.Website.domain;

/**
 * 商品展示
 */
public class Pics {

    private Long id;
    private Long goodsId;
    private String picurl;
    private Long adminId;

    public Pics() {
    }

    public Pics(Long id, Long goodsId, String picurl, Long adminId) {
        this.id = id;
        this.goodsId = goodsId;
        this.picurl = picurl;
        this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Pics{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", picurl='" + picurl + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
