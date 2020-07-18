package com.jessie.mall.cloudsecurityservice.controller;

import com.jessie.mall.cloudsecurityservice.service.UserService;
import com.jessie.mall.sys.Permission;
import com.jessie.mall.sys.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/13 16:51
 */
@RestController
@RequestMapping("/User/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findUserByName")
    public User findUserByName(@RequestParam("username")  String username){
       return userService.findUserByUsername(username);
    }

    @RequestMapping("/findPermissionsByName")
    public List<Permission> findPermissionsByName(@RequestParam("username")  String username){
        return userService.findPermissionsByUserName(username);
    }
}
