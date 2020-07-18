package com.jessie.mall.cloudsecurityservice.mapper;
import com.jessie.mall.sys.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PermissionMapper {
    // 查询所有权限
    @Select(" select * from sys_permission ")
    List<Permission> findAllPermission();

}
