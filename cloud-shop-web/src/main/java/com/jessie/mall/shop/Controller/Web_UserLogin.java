package com.jessie.mall.shop.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 9:44
 */
@RestController
@RequestMapping("/User/user")
public class Web_UserLogin {

    @RequestMapping("/loginName")
    public Map<String,String> longinName(){
        Map<String,String> map=new HashMap<>();
        //获取当前登陆用户的名字
        String loginName= SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("loginName",loginName);
        return map;
    }
}
