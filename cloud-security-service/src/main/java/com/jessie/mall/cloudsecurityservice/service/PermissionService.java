package com.jessie.mall.cloudsecurityservice.service;
import com.jessie.mall.cloudsecurityservice.mapper.PermissionMapper;
import com.jessie.mall.sys.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public interface PermissionService {


     List<Permission> findAllPermission();
}
