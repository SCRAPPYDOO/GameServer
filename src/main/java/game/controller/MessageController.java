package game.controller;

import game.dto.ChatMessage;
import game.dto.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@EnableScheduling
@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000)
    public void greeting() {
        System.out.println("scheduled");
        ChatMessage message = new ChatMessage("from server", "message");
        this.template.convertAndSend("/chat/warcaby", message);
    }

    @MessageMapping("/message")
    @SendTo("/chat")
    public OutputMessage send(ChatMessage message) throws Exception {
        return null;
    }
}
