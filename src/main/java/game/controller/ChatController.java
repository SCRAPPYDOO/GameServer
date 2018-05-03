package game.controller;

import game.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat/warcaby")
    @SendTo("/chat/warcaby")
    public ChatMessage send(ChatMessage message) throws Exception {
        return message;
    }
}
