package fr.paul.websocket.websocket;

import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul
 */
@ServerEndpoint("/hub")
public class HubProject{

    static List<Session> sessions = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger("Chat");

    @OnMessage
    public void onMessage(String message, Session session){
        LOG.info(message);
        try {
            for (Session sess : sessions) {
                if (!sess.getId().equals(session.getId())) {
                    sess.getBasicRemote().sendText(message);
                }
            }

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        LOG.info(session);
    }

    @OnOpen
    public void onOpen(Session session){
        sessions.add(session);
		LOG.info(session);
    }

    @OnClose
    public void onClose(CloseReason reason, Session session){
        sessions.remove(session);
        LOG.info(reason);
    }

}
