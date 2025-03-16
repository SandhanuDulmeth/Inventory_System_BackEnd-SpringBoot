package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Update MessageController to include full path
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageRepository messageRepository;

    // Add constructor injection
    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = messageRepository.findTop100ByOrderByCreatedAtAsc();
        return ResponseEntity.ok(messages);
    }
}
