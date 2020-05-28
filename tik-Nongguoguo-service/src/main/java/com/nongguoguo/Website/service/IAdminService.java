package com.nongguoguo.Website.service;




import com.nongguoguo.Website.domain.Admin;
import com.nongguoguo.Website.domain.AdminDetails;
import com.nongguoguo.Website.domain.Menu;
import com.nongguoguo.Website.dto.AdminParam;
import com.nongguoguo.Website.dto.Loginparam;
import com.nongguoguo.Website.dto.UpdateAdminPasswordParam;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 *
 */
public interface IAdminService {

    //验证token是否有效
    CommonResult checktoken(String token);
    //通过openid查询
    AdminDetails selectByOpenid(String openid);
    //通过id查询
    Admin selectById(Serializable id);
    //查询全部
    List<Admin> selectAll();
    //通过用户名查询
    Admin selectByUserName(String name);
    //
    AdminDetails loadUserByUsername(String name);
    //
    List<Menu> selectMenuByAdminId(Long id);
    //注册
    CommonResult register(AdminParam admin);
    //小程序注册
    CommonResult tikregister(String code,String avatarUrl,String nickName);
    //刷新token
    String refreshToken(String oldtoken);
    //修改密码
    int updatePassword(UpdateAdminPasswordParam updateAdminPasswordParam);
    //修改权限
    int updatePermission(Long adminId, List<Long> permissionIds);
     //登录功能
    Loginparam login(Map<String, String> params);
    void insert(Admin t);
    //Serializable是Long，string等等的顶级接口
    void deleteById(Serializable id);
    void updateById(Admin t);

}
