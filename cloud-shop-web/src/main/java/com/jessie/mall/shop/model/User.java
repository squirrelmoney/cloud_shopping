package com.jessie.mall.shop.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 23:53
 */
public class User extends com.jessie.mall.sys.User implements UserDetails {
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities() {
        if (this.getPermissionList()!=null&&this.getPermissionList().size()>0){
            List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
            this.getPermissionList().stream().forEach(e->{
                auths.add(new SimpleGrantedAuthority(e.getPermTag()));
            });
            this.authorities=auths;
        }
    }

    public void setAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.authorities=grantedAuthorities;
    }
}
