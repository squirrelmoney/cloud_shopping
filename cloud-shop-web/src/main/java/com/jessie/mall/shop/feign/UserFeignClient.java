package com.jessie.mall.shop.feign;

import com.jessie.mall.shop.model.User;
import com.jessie.mall.sys.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/15 0:19
 */
@FeignClient("cloud-security-service")
public interface UserFeignClient {
    @RequestMapping("/User/user/findUserByName")
    User findUserByName(@RequestParam("username")   String username);

    @RequestMapping("/User/user/findPermissionsByName")
     List<Permission> findPermissionsByName(@RequestParam("username")  String username);
}
