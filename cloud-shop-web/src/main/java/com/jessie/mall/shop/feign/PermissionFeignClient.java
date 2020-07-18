package com.jessie.mall.shop.feign;

import com.jessie.mall.sys.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/15 0:32
 */
@FeignClient("cloud-security-service")
public interface PermissionFeignClient {

    @RequestMapping("/Permission/permission/findAllPermissions")
     List<Permission> findAllPermissions();
}
