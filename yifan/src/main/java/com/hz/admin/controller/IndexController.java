package com.hz.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.admin.config.TagCache;
import com.hz.pojo.Blog;
import com.hz.pojo.Friend;
import com.hz.pojo.User;
import com.hz.service.BlogService;
import com.hz.service.FriendService;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private BlogService blogService;


    /* 广告页*/
    @GetMapping("/toAd")
    public String addAd(){
        return "ad";
    }

    /* 聊天室*/
    @GetMapping("/people")
    public String people(Model model, HttpSession session){
        // 在线的人
        LambdaQueryWrapper<User> wrapper4 = new LambdaQueryWrapper<>();
        User currentUser = (User)session.getAttribute("user");
        wrapper4.ne(User::getUName,currentUser.getUName()).eq(User::getUState,1);
        List<User> touser = userService.list(wrapper4);
        if(touser.size() == 0){
            System.err.println(touser.size());
            model.addAttribute("nouser",true);
        } else {
            model.addAttribute("nouser",false);
        }
        model.addAttribute("touser",touser);
        return "chat";
    }


    /* 友情链接列表*/
    @GetMapping("/friendTab")
    public String friend(Integer current,Integer size, Model model){
        Page<Friend> page = new Page<>(current,size);
        Page<Friend> friendPage = friendService.page(page);
        model.addAttribute("friendPage",friendPage);
        return "friendTab";
    }

    /*文章列表*/
    @GetMapping("/BlogTab")
    public String blogTab(Integer type,Integer current,Integer size, Model model){
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getBlogType,type);
        Page<Blog> page = new Page<>(current, size);
        Page<Blog> blogPage = blogService.page(page, wrapper);
        //    List<Blog> blogList = blogPage.getRecords();

        model.addAttribute("type",type);
        model.addAttribute("blogPage",blogPage);
        return "blogTab";
    }


    /*未授权*/
    @GetMapping("/noAuth")
    public String noauth(){
        return "noAuth";
    }

    /*我们*/
    @GetMapping("/our")
    public String our(){
        return "our";
    }

    /*文章*/
    @GetMapping("/publish")
    public String toPublish(Model model){
        // 得到标签
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }

    /*首页*/
    @GetMapping("/index")
    public String index(){
        return "index";
    }





}
