package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;

import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        message.setTimestamp(System.currentTimeMillis());
        Message savedMessage = messageRepository.save(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/chat/{customerId}")
    public ResponseEntity<List<Message>> getChat(@PathVariable Long customerId) {
        List<Message> messages = messageRepository.findByCustomerId(customerId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
