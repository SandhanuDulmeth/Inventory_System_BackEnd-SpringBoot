package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private MessageRepository messageRepository;

    // Endpoint to get all unique customer IDs that have interacted with the admin
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
