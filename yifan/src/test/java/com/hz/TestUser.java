package com.hz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hz.pojo.Blog;
import com.hz.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

    @Autowired
    private BlogService blogService;

    @Test
    public void getBlogs(){
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();

        List<Blog> blogList = blogService.list(null);

        blogList.forEach(System.err::println);
    }



}
