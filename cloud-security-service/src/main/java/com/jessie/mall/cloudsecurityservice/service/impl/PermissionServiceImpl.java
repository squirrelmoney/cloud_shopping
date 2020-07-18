package com.jessie.mall.cloudsecurityservice.service.impl;

import com.jessie.mall.cloudsecurityservice.mapper.PermissionMapper;
import com.jessie.mall.cloudsecurityservice.mapper.UserMapper;
import com.jessie.mall.cloudsecurityservice.service.PermissionService;
import com.jessie.mall.sys.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 23:29
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.findAllPermission();
    }
}
