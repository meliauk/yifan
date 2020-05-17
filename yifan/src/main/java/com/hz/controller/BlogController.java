package com.hz.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.pojo.Blog;
import com.hz.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    // 相关文章
    @GetMapping("/yifan/sameBlog")
    // 根据标签进行匹配
    public List<Blog> sameBlog(String label,Integer count){

        List<Blog> list = new ArrayList<>();

        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getBlogPublishType,label);
        List<Blog> sameList = blogService.list(wrapper);
        int i = 1;
        if( sameList.size() < count ){
            return sameList;
        }else {
            do {
                int nextInt = new Random().nextInt(sameList.size());
                list.add(   sameList.get(nextInt)  );
                sameList.remove(nextInt);
                i ++;
            }while (i <= count);

            return list;
        }

    }


    // ours
    @GetMapping("/yifan/seleOur")
    public List<Blog> getOurs(Model model){
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getBlogType,2);
        List<Blog> list = blogService.list(wrapper);
        return list;
    }

    // blog
    @GetMapping("/yifan/blogs")
    public Page<Blog> getBlogs(Model model,@RequestParam Integer current,@RequestParam Integer size){
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getBlogType,1);
        Page<Blog> page = new Page<>(current, size);
        Page<Blog> blogList = blogService.page(page,wrapper);
        return blogList;
    }


    // 搜索
    @PostMapping("/yifan/seleblog")
    public Page<Blog> seleBlogs(@RequestParam String info,@RequestParam Integer current,@RequestParam Integer size){
        System.err.println(" ==> "+info + current + size);
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Blog::getBlogTitle,"%"+info+"%")
                .or()
                .like(Blog::getBlogDesc,"%"+info+"%")
                .or()
                .like(Blog::getBlogPublishType,"%"+info+"%");


        Page<Blog> page = new Page<>(current, size);
        Page<Blog> blogList = blogService.page(page,wrapper);

        return blogList;

    }

}
