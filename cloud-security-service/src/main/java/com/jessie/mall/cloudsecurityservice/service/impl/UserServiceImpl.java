package com.jessie.mall.cloudsecurityservice.service.impl;

import com.jessie.mall.cloudsecurityservice.mapper.UserMapper;
import com.jessie.mall.cloudsecurityservice.service.UserService;
import com.jessie.mall.sys.Permission;
import com.jessie.mall.sys.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 23:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findUserByUsername(String Username) {
        return userMapper.findUserByUsername(Username);
    }

    @Override
    public List<Permission> findPermissionsByUserName(String username) {
        return userMapper.findPermissionByUsername(username);
    }
}
