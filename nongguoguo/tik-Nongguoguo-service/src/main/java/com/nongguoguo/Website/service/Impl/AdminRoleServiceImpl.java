package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.AdminRole;
import com.nongguoguo.Website.mapper.AdminRoleMapper;
import com.nongguoguo.Website.service.IAdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole> implements IAdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public void deleteByAdminId(Long adminId) {
        AdminRole adminRole = adminRoleMapper.selectByAdminId(adminId);
        adminRoleMapper.deleteById(adminRole.getId());
    }
}
