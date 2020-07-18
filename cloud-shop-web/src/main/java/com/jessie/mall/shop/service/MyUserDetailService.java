package com.jessie.mall.shop.service;


import com.jessie.mall.shop.model.User;
import com.jessie.mall.shop.feign.UserFeignClient;
import com.jessie.mall.sys.Permission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: money
 * @time: 2020/7/13 16:56
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserFeignClient userFeignClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
        User user=userFeignClient.findUserByName(username);
        if (!Objects.isNull(user)){
            List<Permission> permissions=userFeignClient.findPermissionsByName(username);
           if (permissions!=null&&permissions.size()>0){
               permissions.stream().forEach(e->{
                   System.out.println("==权限数据=="+e.getPermTag());
                   grantedAuthorities.add(new SimpleGrantedAuthority(e.getPermTag()));
               });
               user.setAuthorities(grantedAuthorities);
               System.out.println(user);
           }
            return user;
        }else{
            return null;
    }
    }
}
