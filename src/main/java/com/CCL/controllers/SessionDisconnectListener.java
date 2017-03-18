package com.CCL.controllers;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.HashMap;

/**
 * Created by Mike on 3/17/2017.
 */
public class SessionDisconnectListener implements ApplicationListener<SessionDisconnectEvent> {
    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        String sessionId = event.getSessionId();
        HashMap m = new HashMap();
        m.put("id", sessionId);
        WebSocketController.messenger.convertAndSend("remove-user", m);
    }
}
