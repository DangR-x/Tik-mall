package com.nongguoguo.Website.domain;

import java.util.Date;


/**
 * 权限表
 */
public class Resource {

    private Long id;
    private Date createTime;
    private String name;
    private String url;
    private String description;
    private String categoryId;

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Resource() {
    }

    public Resource(Long id, Date createTime, String name, String url, String description, String categoryId) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.url = url;
        this.description = description;
        this.categoryId = categoryId;
    }
}


