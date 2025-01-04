package com.acautomaton.gym.real;

import com.acautomaton.gym.dao.AdminUserDao;
import com.acautomaton.gym.entity.AdminUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminUserDao adminuserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        AdminUser adminuser = adminuserDao.findByAdminNameAndAdminPassword(token.getUsername(), String.copyValueOf(token.getPassword()));
        if (null == adminuser) {
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(adminuser.getAdminName(), adminuser.getAdminPassword(), "");
        System.out.println("完成认证！");
        return info;
    }
}
