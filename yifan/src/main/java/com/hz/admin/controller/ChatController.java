package com.hz.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hz.admin.dto.SocketMessage;
import com.hz.admin.service.SocketService;
import com.hz.pojo.User;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChatController {


    @Autowired
    private SocketService socketService;

    @Autowired
    private UserService userService;



    /* 接收消息     @SendToUser 谁发送的返回给谁  */
    @MessageMapping("/chat")
    public void broadCast(SocketMessage message){
        socketService.sendToMsg(message);
    }


    /* 发送给个人*/
    @MessageMapping("/chatTo")
    public void serverSendUesrMsg(SocketMessage message){
        socketService.sendToUserMsg(message);
    }


}
