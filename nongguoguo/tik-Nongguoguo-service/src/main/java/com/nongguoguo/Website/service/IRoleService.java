package com.nongguoguo.Website.service;



import com.nongguoguo.Website.domain.Menu;
import com.nongguoguo.Website.domain.Role;

import java.util.List;

/**
 *
 */
public interface IRoleService extends BaseService<Role> {

    List<Menu> getMenuByAdminId(Long id);

}
