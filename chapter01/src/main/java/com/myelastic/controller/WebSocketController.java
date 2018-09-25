package com.myelastic.controller;

import com.myelastic.util.WebSocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * websocket简易聊天
 * Created by zhanglu on 2018/9/20.
 */
@Component
@ServerEndpoint(value="/my-chat/{usernick}")
//@RestController("/my-chat/{usernick}")
@Slf4j
public class WebSocketController {
    /**
     * 连接事件
     * @param usernick
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam(value="usernick")String usernick,Session session){
        String message="有新游客["+usernick+"[加入聊天室";
        log.info(message);
        WebSocketUtil.addSession(usernick, session);
        WebSocketUtil.sendMessageForAll(message);

    }
    @OnClose
    public void onClose(@PathParam(value = "usernick")String usernick,Session session){
        String message="游客["+usernick+"]退出聊天";
        log.info(message);
        WebSocketUtil.remoteSession(usernick);
        WebSocketUtil.sendMessageForAll(message);
    }
    @OnMessage
    public void OnMessage(@PathParam(value = "usernick")String userNick,String message){
//        群发消息
        String info="游客["+userNick+"]:"+message;
        log.info(info);
//        WebSocketUtil.sendMessageForAll(message);
        WebSocketUtil.sendMessageForAll(message);
    }
    @OnError
    public void onError(Session session,Throwable throwable){
        log.error("异常："+throwable);
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }
}
