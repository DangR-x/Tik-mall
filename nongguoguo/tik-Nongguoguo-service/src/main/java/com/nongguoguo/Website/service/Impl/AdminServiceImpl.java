package com.nongguoguo.Website.service.Impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nongguoguo.Website.config.Tikconfig;
import com.nongguoguo.Website.domain.*;
import com.nongguoguo.Website.dto.AdminParam;
import com.nongguoguo.Website.dto.LoginAdminParam;
import com.nongguoguo.Website.dto.Loginparam;
import com.nongguoguo.Website.dto.UpdateAdminPasswordParam;
import com.nongguoguo.Website.jwtsecurity.utils.CommonResult;
import com.nongguoguo.Website.jwtsecurity.utils.JwtTokenUtil;
import com.nongguoguo.Website.mapper.AdminMapper;
import com.nongguoguo.Website.mapper.ResourceMapper;
import com.nongguoguo.Website.service.IAdminRoleService;
import com.nongguoguo.Website.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by J on 2020/5/21 17:03
 */
@Slf4j
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private IAdminRoleService adminRoleService;

    /**
     * @param  params 前端传来的code
     * @return  tik小程序登录信息
     */
    @Override
    public Loginparam login(Map<String, String> params) {

        JSONObject sessionKeyOropenid = Tikconfig.getSessionKeyOropenid(params.get("code"));
        Loginparam loginparam = JSONUtil.toBean(sessionKeyOropenid, Loginparam.class);
        String openid = loginparam.getOpenid();
        //通过openid查找出用户并生成token
        AdminDetails admin = selectByOpenid(openid);
        String s = jwtTokenUtil.generateToken(admin);
        loginparam.setUid(admin.getAdmin().getId());
        loginparam.setToken(s);
        return loginparam;
    }


    /**
     *
     * @param code
     * @param avatarUrl
     * @param nickName
     * @return  Loginparam
     */
    @Override
    public CommonResult tikregister(String code, String avatarUrl, String nickName) {
        //通过code获取openid和sessionkey
        JSONObject openid = Tikconfig.getSessionKeyOropenid(code);
        LoginAdminParam loginAdminParam = JSONUtil.toBean(openid, LoginAdminParam.class);
        loginAdminParam.setAvatarUrl(avatarUrl);
        loginAdminParam.setNickName(nickName);
        loginAdminParam.setUsername(nickName);
        loginAdminParam.setPassword("123456");

        Admin admin = new Admin();
        BeanUtils.copyProperties(loginAdminParam,admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        Admin userName = selectByUserName(admin.getUsername());
        if(userName != null){
            return CommonResult.failed("用户名已被占用!");
        }
        String encode = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        try {
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("注册失败请联系管理员!");
        }
        AdminRole adminRole = new AdminRole(admin.getId(),5L);
        adminRoleService.insert(adminRole);
        String openid1 = admin.getOpenid();
        HashMap<String, String> codemap = new HashMap<>();
        codemap.put("code",openid1);
        Loginparam login = login(codemap);
        return CommonResult.success(0,login);

    }

    /**
     *
     * @param token
     * @return
     */
    @Override
    public CommonResult checktoken(String token) {
        String userNameFromToken = jwtTokenUtil.getUserNameFromToken(token);
        Admin admin = selectByUserName(userNameFromToken);
        if(!StringUtils.isEmpty(admin)){
            return CommonResult.success(0,admin);
        }
        return CommonResult.failed();
    }
    //通过openid查询用户
    @Override
    public AdminDetails selectByOpenid(String openid) {
        Admin admin = adminMapper.selectByOpenid(openid);
        if(admin!=null){
            List<Resource> resources = resourceMapper.getResourceByAminId(admin.getId());
            AdminDetails adminDetails = new AdminDetails(admin,resources);
            return adminDetails;
        }
        throw new UsernameNotFoundException("用户名输入错误!");
    }


    /**
     *
     * @param name  通过用户名查询用户,在jwtauthenticaiongfilter中调用判断该用户是否有某个权限
     * @return
     */
    @Override
    public AdminDetails loadUserByUsername(String name) {
        Admin admin = selectByUserName(name);
        if(admin!=null){
            List<Resource> resources = resourceMapper.getResourceByAminId(admin.getId());
            AdminDetails adminDetails = new AdminDetails(admin,resources);
            return adminDetails;
        }
        throw new UsernameNotFoundException("用户名输入错误!");
    }


    /**
     *
     * @param adminParam   注册
     * @return
     */
    @Override
    public CommonResult register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam,admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        Admin userName = selectByUserName(admin.getUsername());
        if(userName != null){
            return CommonResult.failed("用户名已被占用!");
        }
        String encode = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        try {
            adminMapper.insert(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("注册失败请联系管理员!");
        }
        AdminRole adminRole = new AdminRole(admin.getId(),5L);
        adminRoleService.insert(adminRole);
        return CommonResult.success(admin);
    }


    /**
     *
     * @param oldtoken
     * @return  newtoken
     */
    @Override
    public String refreshToken(String oldtoken) {
        return jwtTokenUtil.refreshHeadToken(oldtoken);
    }

    /**
     *
     * @param updateAdminPasswordParam
     * @return   -1 用户名为空 -2 没有该用户 -3 旧密码错误
     */
    @Override
    public int updatePassword(UpdateAdminPasswordParam updateAdminPasswordParam) {
        String username = updateAdminPasswordParam.getUsername();
        if(StringUtils.isEmpty(username)){
            return -1;
        }
        Admin admin = selectByUserName(username);
        if(StringUtils.isEmpty(admin)){
            return -2;
        }
        if(!passwordEncoder.matches(updateAdminPasswordParam.getOldPassword(),admin.getPassword())){
            return -3;
        }
        admin.setPassword(passwordEncoder.encode(updateAdminPasswordParam.getNewPassword()));
        adminMapper.updateByName(admin);
        return 1;
    }


    /**
     *
     * @param adminId
     * @param permissionIds  修改商户商品管理权限
     * @return  0成功   -1失败
     */
    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        //通过用户id删除用户的权限
        try {
            adminRoleService.deleteByAdminId(adminId);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     *
     * @param id
     * @return  菜单列表
     */
    @Override
    public List<Menu> selectMenuByAdminId(Long id){
        List<Menu> menus = adminMapper.selectMenuByAdminId(id);
        return menus;
    }

    @Override
    public void insert(Admin t) {
        adminMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void updateById(Admin t) {
        adminMapper.updateById(t);
    }

    @Override
    public Admin selectById(Serializable id) {
        return adminMapper.selectById(id);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin selectByUserName(String name) {
        return adminMapper.selectByName(name);
    }


}
