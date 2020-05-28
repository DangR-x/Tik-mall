package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.Admin;
import com.nongguoguo.Website.domain.Permission;
import com.nongguoguo.Website.jwtsecurity.utils.JwtTokenUtil;
import com.nongguoguo.Website.mapper.PermissionMapper;
import com.nongguoguo.Website.service.IAdminService;
import com.nongguoguo.Website.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private IAdminService adminService;

    @Override
    public List<Permission> getPermissionByToken(String token) {

        String name = jwtTokenUtil.getUserNameFromToken(token);
        if(!StringUtils.isEmpty(name)){
            Admin admin = adminService.selectByUserName(name);
            List<Permission> permissions = getPermissionByAdminId(admin.getId());
            return permissions;
        }
        return null;
    }

    @Override
    public List<Permission> getPermissionByAdminId(Long id) {
        List<Permission> permissions = permissionMapper.getPermissionByAdminId(id);
        return permissions;
    }
}
