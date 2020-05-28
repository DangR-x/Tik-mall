package com.nongguoguo.Website.domain;

import java.util.Date;

/**
 *
 */
public class Menu {

    private Long id;
    private Long parentId;
    private Date createTime;
    private String title;
    private Integer level;
    private Integer sort;
    private String name;
    private String icon;
    private Integer hidden;

    public Menu() {
    }

    public Menu(Long id, Long parentId, Date createTime, String title, Integer level, Integer sort, String name, String icon, Integer hidden) {
        this.id = id;
        this.parentId = parentId;
        this.createTime = createTime;
        this.title = title;
        this.level = level;
        this.sort = sort;
        this.name = name;
        this.icon = icon;
        this.hidden = hidden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", sort=" + sort +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
