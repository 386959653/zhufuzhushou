package com.weichi.erp.component.springSecurity;

import com.weichi.erp.dao.SysRoleMapper;
import com.weichi.erp.dao.SysUserMapper;
import com.weichi.erp.dao.UserRoleMapper;
import com.weichi.erp.domain.SysRole;
import com.weichi.erp.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wewon on 2018/5/28 9:38
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SysUserMapper sysUserMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 根据用户名，查找到对应的密码，与角色
        SysUser sysUserCondition = new SysUser();
        sysUserCondition.setUsername(s);
        SysUser sysUser = sysUserMapper.selectOne(sysUserCondition);
        if (sysUser == null) {
            throw new UsernameNotFoundException("找不到用户名");
        }

        List<Object> roleNameList = new SysRole().sql().selectObjs("SELECT t3.`role_name` FROM sys_role t3 WHERE t3.`id` IN" +
                        "( SELECT t.`pid` FROM sys_role t WHERE t.`id` IN (SELECT t2.`role_id`  FROM user_role t2 WHERE t2.`user_id`={0}))\n" +
                        "UNION \n" +
                        "SELECT t.`role_name` FROM sys_role t WHERE t.`id` IN (SELECT t2.`role_id`  FROM user_role t2 WHERE t2.`user_id`={0})"
                , sysUser.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Object roleName : roleNameList) {
            authorities.add(new SimpleGrantedAuthority(roleName.toString()));
        }

        // 封装用户信息，并返回。参数分别是：用户id，用户名，密码，用户角色
        MyUserDetails user = new MyUserDetails(sysUser.getId(), s, sysUser.getPassword(), authorities);
        return user;
    }
}
