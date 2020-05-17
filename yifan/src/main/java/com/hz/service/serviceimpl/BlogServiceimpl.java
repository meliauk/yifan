package com.hz.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.mapper.BlogMapper;
import com.hz.pojo.Blog;
import com.hz.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceimpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
