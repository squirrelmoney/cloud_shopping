package com.jessie.mall.shop.service;


import com.jessie.mall.shop.feign.PermissionFeignClient;
import com.jessie.mall.sys.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {

    @Resource
    private PermissionFeignClient permissionFeignClient;

    public List<Permission> findAllPermission(){
        return permissionFeignClient.findAllPermissions();
    }
}
