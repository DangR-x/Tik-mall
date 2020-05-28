package com.nongguoguo.Website.mapper;


import com.nongguoguo.Website.domain.Admin;
import com.nongguoguo.Website.domain.AdminDetails;
import com.nongguoguo.Website.domain.Menu;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.List;


/**
 *
 */
@Component
public interface AdminMapper {

    void insert(Admin t);

    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);

    void updateById(Admin t);

    Admin selectById(Serializable id);

    List<Admin> selectAll();

    Admin selectByName(String username);

    void updateByName(Admin admin);

    List<Menu> selectMenuByAdminId(Long id);

    Admin selectByOpenid(String openid);


}
