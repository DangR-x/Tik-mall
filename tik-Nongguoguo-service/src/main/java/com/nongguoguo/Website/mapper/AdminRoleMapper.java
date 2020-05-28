package com.nongguoguo.Website.mapper;


import com.nongguoguo.Website.domain.AdminRole;

/**
 * Created by J on 2020/5/22 17:30
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    AdminRole selectByAdminId(Long id);
}
