package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
public class HelpSupportController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) throws Exception {
        // Simulating message processing (could be more complex in a real app)
        return new Message("User: " + message.getText());
    }
}