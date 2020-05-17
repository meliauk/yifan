package com.hz.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hz.pojo.User;
import com.hz.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping({"/","login"})
    public String tologin(){
        return "login";
    }

    /*登出*/
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        session.removeAttribute("user");
        subject.logout();
        model.addAttribute("msg","安全退出");
        return "login";
    }

    /*
     * 登录
     * */
    @PostMapping("/yifan/toindex")
    public String toindex(@RequestParam String username , @RequestParam String password,Integer rememberMe , Model model, HttpSession session){

        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password);
   /*     if(rememberMe != null && rememberMe == 1) {
            System.err.println(" rememberMe = "+rememberMe);
            //开启记住我功能
            token.setRememberMe(true);
        }*/

        //开启记住我功能
        token.setRememberMe(true);

            // 执行登录的方法
        try {
            // 执行 subject.login  就会到 UserRealm 的认证操作
            subject.login(token);

            User currentUser = (User)session.getAttribute("user");
            LambdaQueryWrapper<User> wra = new LambdaQueryWrapper<>();
            wra.eq(User::getUName,currentUser.getUName());
            User u = new User();
            u.setUState(1);
            userService.update(u,wra);

            return "redirect:/admin/index";
        }catch (UnknownAccountException e){//用户名不正确
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch ( IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

}
