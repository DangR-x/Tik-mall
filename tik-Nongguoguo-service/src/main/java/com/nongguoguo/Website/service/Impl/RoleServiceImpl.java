package com.nongguoguo.Website.service.Impl;


import com.nongguoguo.Website.domain.Menu;
import com.nongguoguo.Website.domain.Role;
import com.nongguoguo.Website.mapper.RoleMapper;
import com.nongguoguo.Website.service.IAdminService;
import com.nongguoguo.Website.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private IAdminService adminService;

    @Override
    public List<Menu> getMenuByAdminId(Long id) {
        return roleMapper.getMenuByAdminId(id);
    }


}
