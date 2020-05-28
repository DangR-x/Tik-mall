package com.nongguoguo.Website.domain;

import java.util.Date;

/**
 * Created by J on 2020/5/22 14:11
 */
public class Role {

    private Long id;
    private String name;
    private String description;
    private Integer adminCount;
    private Date createTime;
    private Integer status;
    private Integer sort;

    public Role() {
    }

    public Role(Long id, String name, String description, Integer adminCount, Date createTime, Integer status, Integer sort) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.adminCount = adminCount;
        this.createTime = createTime;
        this.status = status;
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adminCount=" + adminCount +
                ", createTime=" + createTime +
                ", status=" + status +
                ", sort=" + sort +
                '}';
    }
}
