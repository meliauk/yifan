package com.hz.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.mapper.UserMapper;
import com.hz.pojo.User;
import com.hz.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl extends ServiceImpl<UserMapper, User> implements UserService {
}
