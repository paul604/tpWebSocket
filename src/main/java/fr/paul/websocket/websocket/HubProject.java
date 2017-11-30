package fr.paul.websocket.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author Paul
 */
@ServerEndpoint("/hub")
public class HubProject{

	private static final Logger LOG= Logger.getLogger("Chat");
    @OnMessage
    public void onMessage(String message, Session session){
		LOG.info(message);
		try {
			session.getBasicRemote().sendText("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        LOG.info(session);
    }

    @OnOpen
    public void onOpen(Session session){
		LOG.info(session);
    }

    @OnClose
    public void onClose(CloseReason reason, Session session){
        LOG.info(reason);
    }

}
