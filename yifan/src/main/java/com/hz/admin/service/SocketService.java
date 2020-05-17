package com.hz.admin.service;

import com.hz.admin.dto.SocketMessage;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface SocketService {

    public void sendToMsg(SocketMessage socketMessage);
    public void sendToUserMsg(SocketMessage msg);

}
