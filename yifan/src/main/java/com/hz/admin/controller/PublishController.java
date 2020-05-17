package com.hz.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.io.Files;
import com.hz.admin.config.TagCache;
import com.hz.admin.config.UserRealm;
import com.hz.pojo.Ad;
import com.hz.pojo.Blog;
import com.hz.pojo.Friend;
import com.hz.pojo.User;
import com.hz.service.AdService;
import com.hz.service.BlogService;
import com.hz.service.FriendService;
import com.hz.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/publish")
public class PublishController {


    @Autowired
    private BlogService blogService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdService adService;

    /* 上传图片*/
    @PostMapping("/uploadImage")
    public @ResponseBody Map<String,Object> uploadImage( HttpServletRequest request, @RequestParam("editormd-image-file") MultipartFile file ){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("success", 1);
        resultMap.put("message", "上传成功！");
        resultMap.put("url", "/images/ok.jpg");
        System.out.println(file.getOriginalFilename());
        return resultMap;

    }

    @PostMapping("/addAd")
    public String addAd(String adTitle,String adUrl,String adGmtStart,
                        String adGmtEnd,String adPos,
                        Model model){

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime gmtStart = LocalDateTime.parse(adGmtStart);
        LocalDateTime gmtEnd = LocalDateTime.parse(adGmtEnd);

        Ad ad = new Ad();
        ad.setAdTitle(adTitle);
        ad.setAdUrl(adUrl);
        ad.setAdGmtStart(gmtStart);
        ad.setAdGmtEnd(gmtEnd);
        ad.setAdGmtCreate(LocalDateTime.now());
        ad.setAdPos(adPos);
        ad.setAdStatus(1);
        adService.save(ad);
        model.addAttribute("okmsg","发布广告成功");
        return "isOK";
    }


    /*数量*/
    @GetMapping("/count")
    @ResponseBody
    public String count(){
        // 我的博客数量
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getBlogType,1);
        int count1 = blogService.count(wrapper);
        // 我们的文章数量
        LambdaQueryWrapper<Blog> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(Blog::getBlogType,2);
        int count2 = blogService.count(wrapper2);

        // 友链数量
        int count3 = friendService.count();

        // 在线的人数
        LambdaQueryWrapper<User> wrapper3 = new LambdaQueryWrapper<>();
        wrapper3.eq(User::getUState,1);
        int count4 = userService.count(wrapper3);

        // 总人数
        int count5 = userService.count();


        // 广告数量
        int count6 = adService.count();


        String count = String.valueOf(count1+ "_"+count2+"_"+count3+"_"+count4+"_"+count5+"_"+count6);
        return count;
    }



    /**
     * 发布文章
     */
    @PostMapping("/addBlog")
    public String addBlog(@RequestParam String blogTitle ,
                          @RequestParam String blogType ,
                          @RequestParam String blogDesc ,
                          @RequestParam String updateFileimg ,
                          @RequestParam String blogContent,
                          @RequestParam(required = false) String tag,
                          Model model,
                          HttpServletRequest request){

        System.err.println(" tag " + tag);
        int type = Integer.parseInt(blogType);
        // 得到标签
        model.addAttribute("tags", TagCache.get());

        if(null == blogTitle || "" == blogTitle){
            System.err.println(" 标题  "+ blogTitle);
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(null == blogContent || "" == blogContent){
            model.addAttribute("error","内容不能为空");
            return "publish";
        }
        if(blogType == "博客文章"){
            if(null == tag || "" == tag){
                model.addAttribute("error","标签不能为空");
                return "publish";
            }
            String invalid = TagCache.filterInvalid(tag);
            if(StringUtils.isNoneBlank(invalid)){
                model.addAttribute("error","输入非法标签"+invalid);
                return "publish";
            }
        }else {
            tag = "我们故事";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (null == user ){
            model.addAttribute("error","用户未登录");
            return "login";
        }

        Blog blog = new Blog();
        blog.setBlogTitle(blogTitle);
        blog.setBlogDesc(blogDesc);
        blog.setBlogContent(blogContent);
        blog.setBlogType(type);
        blog.setBlogPublishType(tag);
        blog.setBlogTime(LocalDateTime.now());
        blog.setBlogAuthor(user.getUName());
//      图片
        int indexOf = updateFileimg.lastIndexOf("\\");
        String newFileName = updateFileimg.substring(indexOf + 1, updateFileimg.length());
        blog.setBlogCoverImg(newFileName);
        //转换小写去空格
        String tagLower =  tag.toLowerCase().replaceAll(" ","");
        blog.setBlogPublishType(tagLower);
        blog.setBlogComm(0L);//评论
        blog.setBlogLike(0L);
        blog.setBlogRead(0L);

        blogService.save(blog);
        model.addAttribute("okmsg","发布文章成功");
        return "isOK" ;
    }


}
