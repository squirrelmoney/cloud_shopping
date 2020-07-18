package com.jessie.mall.sys;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class User  {
    /*用户ID*/
    private Integer id;
    /*用户名称*/
    private String username;
    /*真实姓名*/
    private String realname;
    /*密码*/
    private String password;
    /*创建日期*/
    private Date createDate;
    /*最后登录时间*/
    private Date lastLoginTime;
    /*是否可用*/
    private boolean enabled;
    /*是否过期*/
    private boolean accountNonExpired;
    /*是否锁定*/
    private boolean accountNonLocked;
    /*证书是否过期*/
    private boolean credentialsNonExpired;

    private List<Permission> permissionList;

}
