package com.nongguoguo.Website.domain;

import java.util.Date;

/**
 * 商品类别
 */
public class Category {

    private Long id;
    private Date creatdate;
    private Date update;
    private String icon;
    private boolean isuse;
    private String key;
    private String name;
    private Integer paixu;
    private Long pid;
    private String type;
    private Long adminId;

    public Category() {
    }

    public Category(Long id, Date creatdate, Date update, String icon, boolean isuse, String key, String name, Integer paixu, Long pid, String type, Long adminId) {
        this.id = id;
        this.creatdate = creatdate;
        this.update = update;
        this.icon = icon;
        this.isuse = isuse;
        this.key = key;
        this.name = name;
        this.paixu = paixu;
        this.pid = pid;
        this.type = type;
        this.adminId = adminId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isIsuse() {
        return isuse;
    }

    public void setIsuse(boolean isuse) {
        this.isuse = isuse;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", creatdate=" + creatdate +
                ", update=" + update +
                ", icon='" + icon + '\'' +
                ", isuse=" + isuse +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", paixu=" + paixu +
                ", pid=" + pid +
                ", type='" + type + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
