package com.nongguoguo.Website.mapper;


import com.nongguoguo.Website.domain.Permission;

import java.util.List;

/**
 *
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getPermissionByAdminId(Long id);
}
