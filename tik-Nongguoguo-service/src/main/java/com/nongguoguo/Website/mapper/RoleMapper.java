package com.nongguoguo.Website.mapper;


import com.nongguoguo.Website.domain.Menu;
import com.nongguoguo.Website.domain.Role;

import java.util.List;

/**
 * Created by J on 2020/5/22 14:13
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Menu> getMenuByAdminId(Long id);

}
