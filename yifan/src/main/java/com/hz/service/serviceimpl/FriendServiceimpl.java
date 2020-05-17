package com.hz.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.mapper.FriendMapper;
import com.hz.pojo.Friend;
import com.hz.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceimpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {
}
