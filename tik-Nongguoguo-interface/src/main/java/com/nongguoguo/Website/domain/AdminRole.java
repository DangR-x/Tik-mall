package com.nongguoguo.Website.domain;

/**
 *
 */
public class AdminRole {

    private Long id;
    private Long adminId;
    private Long roleId;

    public AdminRole() {
    }

    public AdminRole(Long adminId, Long roleId) {

        this.adminId = adminId;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", roleId=" + roleId +
                '}';
    }
}
