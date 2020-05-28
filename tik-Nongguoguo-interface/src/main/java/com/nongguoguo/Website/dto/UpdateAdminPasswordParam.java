package com.nongguoguo.Website.dto;

import javax.validation.constraints.NotEmpty;

/**
 *
 */
public class UpdateAdminPasswordParam {


    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "旧密码不能为空")
    private String oldPassword;

    @NotEmpty(message = "新密码不能为空")
    private String newPassword;

    public UpdateAdminPasswordParam() {
    }

    public UpdateAdminPasswordParam(String username, String oldPassword, String newPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "UpdateAdminPasswordParam{" +
                "username='" + username + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
