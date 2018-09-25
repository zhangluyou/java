package com.myelastic.util;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.RemoteEndpoint.Async;
/**
 *
 * Created by zhanglu on 2018/9/20.
 */
public class WebSocketUtil {
    /**
     * 使用map存储在线的session
     */
    private static final Map<String,Session> ONLINE_SESSION=new ConcurrentHashMap<>();

    /**
     * 添加session
     * @param usernick
     * @param session
     */
    public static void addSession(String usernick,Session session){
//        简单的存色session
        ONLINE_SESSION.put(usernick,session);
//        不存在就新增，返回null，存在，不覆盖，返回存在的值
       // ONLINE_SESSION.putIfAbsent(usernick,session);
    }
    public static void remoteSession(String usernick){
        ONLINE_SESSION.remove(usernick);
    }

    /**
     * 向某个用户发送消息
     * @param session 某个用户的session对象
     * @param message
     */
    public static void sendMessage(Session session,String message){
        if(session==null){
            return;
        }
        /**
         * getAsyncRemote()和getBasicRemote()异步和同步
         */
        Async async=session.getAsyncRemote();
        async.sendText(message);
    }
    /**
     * 向所有人在线人发送消息
     */
    public static void sendMessageForAll(String message){
//        jdk8新方法
        ONLINE_SESSION.forEach((sessionId, session) -> sendMessage(session, message));
    }

}
