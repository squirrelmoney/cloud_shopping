package com.jessie.mall.cloudsecurityservice.service;

import com.jessie.mall.sys.Permission;
import com.jessie.mall.sys.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/13 16:56
 */
@Service
public interface UserService {
   User findUserByUsername(String Username);

   List<Permission>  findPermissionsByUserName(String username);
}
