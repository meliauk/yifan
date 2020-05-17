package com.hz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
}
