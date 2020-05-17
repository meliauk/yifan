package com.hz.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.mapper.AdMapper;
import com.hz.pojo.Ad;
import com.hz.service.AdService;
import org.springframework.stereotype.Service;

@Service
public class AdServiceimpl extends ServiceImpl<AdMapper, Ad> implements AdService {
}
