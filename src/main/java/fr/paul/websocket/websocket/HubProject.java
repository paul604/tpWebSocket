package fr.paul.websocket.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Paul
 */
@ServerEndpoint("/hub")
public class HubProject{

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println(message+" "+ session);
    }

    @OnError
    public void onError(Session session, Throwable throwable){

    }

    @OnOpen
    public void onOpen(Session session){

    }

    @OnClose
    public void onClose(CloseReason reason, Session session){

    }

}
