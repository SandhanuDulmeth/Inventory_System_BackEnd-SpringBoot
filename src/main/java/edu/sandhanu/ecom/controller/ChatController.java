package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;
import edu.sandhanu.ecom.model.MessageDTO;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import edu.sandhanu.ecom.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChatController {

    private final MessageRepository messageRepository;

    @Autowired
    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleChatMessage(MessageDTO messageDTO) {
        // Convert DTO to entity
        Message message = new Message();
        message.setCustomerId(messageDTO.getCustomerId());
        message.setContent(messageDTO.getContent());
        message.setTimestamp(System.currentTimeMillis());
        message.setUser(messageDTO.getUser()); // ADMIN or CUSTOMER

        // Save to database
        Message savedMessage = messageRepository.save(message);

        return savedMessage;
    }
    @MessageMapping("/chat/update")
    @SendTo("/topic/messages")
    public Message handleMessageUpdate(MessageDTO messageDTO) {
        Message existing = messageRepository.findById(messageDTO.getId())
                .orElseThrow(() -> new RuntimeException("Message not found"));

        if (!existing.getCustomerId().equals(messageDTO.getCustomerId())) {
            throw new SecurityException("Unauthorized message update");
        }

        existing.setContent(messageDTO.getContent());
        existing.setTimestamp(System.currentTimeMillis());

        return messageRepository.save(existing);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<String>> getAllCustomerIds() {
        List<Message> messages = messageRepository.findAll();
        List<String> customerIds = messages.stream()
                .map(Message::getCustomerId)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    // Endpoint to get chat history with a specific customer
    @GetMapping("/chat/{customerId}")
    public ResponseEntity<List<Message>> getCustomerChat(@PathVariable String customerId) {
        // Now we only need the customerId, since there's a single admin
        List<Message> messages = messageRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable("id") Long id) {
        try {
            messageRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}