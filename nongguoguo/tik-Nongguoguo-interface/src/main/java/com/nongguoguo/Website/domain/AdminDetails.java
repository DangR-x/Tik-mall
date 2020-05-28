package com.nongguoguo.Website.domain;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by J on 2020/5/20 14:01
 */
public class AdminDetails implements UserDetails {

    private Admin admin;
    //需要过滤的路径
    private List<Resource> resourceList;

    public AdminDetails(Admin admin, List<Resource> resourceList) {
        this.admin = admin;
        this.resourceList = resourceList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //将当前用户用有的访问资源全部以id和名称的list注入进容器,方便比较
        List<SimpleGrantedAuthority> collect = resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
        //返回当前用户的角色
        return collect;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    //该用户是否在使用
    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "AdminDetails{" +
                "admin=" + admin +
                ", resourceList=" + resourceList +
                '}';
    }
}
