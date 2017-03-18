package com.CCL.controllers;

import com.CCL.entities.api_access.User;
import com.CCL.entities.messages.ChatMessage;
import com.CCL.services.ChatMessageRepo;
import com.CCL.services.DirectMessageRepo;
import com.CCL.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.HashMap;

/**
 * Created by Mike on 3/17/2017.
 */
@Controller
public class WebSocketController {
    static SimpMessagingTemplate messenger;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        messenger = template;
    }

    @Autowired
    UserRepo users;

    @Autowired
    ChatMessageRepo cms;

    @Autowired
    DirectMessageRepo dms;

    @MessageMapping("/chat-room/{channel}")
    @SendTo("chat-room/{channel}")
    public HashMap<String, String> groupMessage (Message message) {
        if (new String((byte[]) message.getPayload()).length() > 0) {
            HashMap<String, String> json = new HashMap<>();
            HashMap mapper;
            JacksonJsonParser parser = new JacksonJsonParser();
            String payload = new String((byte[]) message.getPayload());
            mapper = (HashMap) parser.parseMap(payload);
            User sender = users.findByUserName((String) mapper.get("sender"));
            User recipient = users.findByUserName((String) mapper.get("recipient"));
            String text = (String) mapper.get("message");
            String channel = (String) mapper.get("channel");
            ChatMessage chatMessage = new ChatMessage(sender.getUserName(), recipient.getUserName(), text);
            cms.save(chatMessage);
            json.put("message", text);
            json.put("sender", sender.getUserName());
            json.put("recipient", recipient.getUserName());
            json.put("channel", channel);
            return json;
        }
        return null;
        }
    }
