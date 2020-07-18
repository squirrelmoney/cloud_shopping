package com.jessie.mall.cloudsecurityservice.mapper;
import com.jessie.mall.sys.Permission;
import com.jessie.mall.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    //根据用户密，查得用户
    @Select("select * from sys_user where username=#{username}")
    public User findUserByUsername(String username);

    // 查询用户的权限
    @Select(" select permission.* from sys_user user" + " inner join sys_user_role user_role"
            + " on user.id = user_role.user_id inner join "
            + "sys_role_permission role_permission on user_role.role_id = role_permission.role_id "
            + " inner join sys_permission permission on role_permission.perm_id = permission.id where user.username = #{userName};")
    List<Permission> findPermissionByUsername(@Param("userName") String userName);
}
