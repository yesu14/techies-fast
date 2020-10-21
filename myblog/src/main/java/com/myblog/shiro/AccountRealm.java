package com.myblog.shiro;

import cn.hutool.json.JSONUtil;
import com.myblog.entity.User;
import com.myblog.service.UserService;
import com.myblog.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken =(JwtToken) token;
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user =userService.getById(Long.valueOf(userId));
        if (user ==null){
            throw new UnknownAccountException("账户不存在");
        }
        if (user.getStatus()==-1){
            throw new LockedAccountException("账户已被锁定");
        }
        AccountProfile profile=new AccountProfile();
        BeanUtils.copyProperties(user,profile);
        System.out.println("-----------------");
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }
}
