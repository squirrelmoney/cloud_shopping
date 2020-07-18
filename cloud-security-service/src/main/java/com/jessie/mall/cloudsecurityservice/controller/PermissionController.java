package com.jessie.mall.cloudsecurityservice.controller;

import com.jessie.mall.cloudsecurityservice.service.PermissionService;
import com.jessie.mall.sys.Permission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 23:38
 */
@RestController
@RequestMapping("/Permission/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping("/findAllPermissions")
    public List<Permission> findAllPermissions(){
        return permissionService.findAllPermission();
    }
}
