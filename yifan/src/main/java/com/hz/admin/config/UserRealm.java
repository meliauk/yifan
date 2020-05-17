package com.hz.admin.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.hz.pojo.User;
import com.hz.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/* 自定义的 UserRealm */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.err.println("执行==> 授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        // 拿到user对象
        User currentUser = (User) subject.getPrincipal();
        String uPower = currentUser.getUPower();
        String[] split = uPower.split(",");
        // 设置当前用户得权限
      //  info.addStringPermission(currentUser.getUPower());
        for (int i = 0 ; i < split.length ; i++){
            info.addStringPermission(split[i]);
        }
        return info;
    }


    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("执行==> 认证doGetAuthorizationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUName, userToken.getUsername());
        User userOne = userService.getOne(wrapper);

        // 用户存到session中
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("user",userOne);

        if(null == userOne){
            // 没用这个人
            return null;
        }
        // 用户名存在
        // 当返回用户密码时，securityManager安全管理器，自动比较返回密码和用户输入密码是否一致
        // 如果密码一致 登录成功， 如果密码不一致 报密码错误异常

        // 密码认证  加密了  第一个参数 可以在 授权 中 接收
        return new SimpleAuthenticationInfo(userOne,userOne.getUPassword(),"");
    }
}
