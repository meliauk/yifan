package com.hz.admin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        //注入自定义cookie(主要是设置寿命, 默认的一年太长)
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        //设置RememberMe的cookie有效期为7天
        simpleCookie.setMaxAge(604800);
        rememberMeManager.setCookie(simpleCookie);
        // 手动设置对称加密秘钥，防止重启系统后系统生成新的随机秘钥，防止导致客户端cookie无效
        rememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return rememberMeManager;
    }

    // 3.创建
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 设置 安全管理器
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro的内置过滤器
        /*
        * anon: 无需认证就可以访问
        * authc: 认证才能访问
        * user: 必须拥有 记住我功能 才能使用
        * perms: 拥有对某个资源的权限时才能访问
        * role: 拥有某个角色权限才能访问
        *
        * */
        // 拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
           /*   无需认证就可以访问*/
        filterMap.put("/css/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/images/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/markdown/**","anon");
        filterMap.put("/logout","anon");
        filterMap.put("/yifan/**","anon");
        filterMap.put("/serverSend/**","anon");

        // 授权 没有授权会跳转到授权页面
        filterMap.put("/admin/publish","perms[user:publish]");
        filterMap.put("/admin/our","perms[user:our]");
        filterMap.put("/**","user");
        // 设置登录页
        factoryBean.setFilterChainDefinitionMap(filterMap);
        factoryBean.setLoginUrl("/");
        factoryBean.setLoginUrl("/login");

        // 未授权页面
        factoryBean.setUnauthorizedUrl("/admin/noAuth");

        // 设置登录请求
        return factoryBean;
    }


    // 2.创建 DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,@Qualifier("rememberMeManager") RememberMeManager rememberMeManager){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联 UserRealm
        manager.setRealm(userRealm);
        //注入记住我管理器
        manager.setRememberMeManager(rememberMeManager);
        return manager;
    }


    // 1.创建 realm 对象
    @Bean(name = "userRealm")
    public UserRealm userRealm(){

        return new UserRealm();
    }

    /*
    * 配置ShiroDialect 用于 thymeleaf 和shiro标签配合使用
    * */
    @Bean
    public ShiroDialect getShiroDia(){
        return new ShiroDialect();
    }


}
