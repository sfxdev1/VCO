package com.keith.vco;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Development on 11/28/2016.
 */
@WebSocket
public class UpdateWebSocket {
    private static final Queue<Session> sessions = new ConcurrentLinkedDeque<>();

    @OnWebSocketConnect
    public void connected(Session session) {
        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) {

    }

    public void sendUpdateMessage() {
        sessions.forEach(session -> {
            try {
                session.getRemote().sendString("update");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
