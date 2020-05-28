package com.nongguoguo.Website.controller;

import com.nongguoguo.Website.domain.Permission;
import com.nongguoguo.Website.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    //通过token获取用户的permission
    @RequestMapping(value = "/getpermission/{token}",method = RequestMethod.GET)
    public List<Permission> getPermission(@PathVariable("token")String token, HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        System.out.println("authorization:"+authorization);
        List<Permission> permissions = permissionService.getPermissionByToken(token);
        return permissions;
    }


}
