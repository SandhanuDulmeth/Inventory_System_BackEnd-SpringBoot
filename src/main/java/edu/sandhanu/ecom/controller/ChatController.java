package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ChatController {

    private final MessageRepository messageRepository;

    @Autowired
    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/sendMessage")  // URL that clients will send messages to
    @SendTo("/topic/messages")  // Broadcasts the message to subscribers
    public String sendMessage(String messageContent) throws Exception {
        // Save the message in the database
        Message message = new Message(messageContent);
        messageRepository.save(message);

        // Broadcast the message to all subscribers
        return messageContent;
    }
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageRepository.findAllByOrderByCreatedAtAsc();
    }
}
