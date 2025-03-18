package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.entity.Message;

import edu.sandhanu.ecom.model.MessageDTO;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import java.util.Optional;

import edu.sandhanu.ecom.util.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Enable CORS for this controller
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final MessageRepository messageRepository;

    public CustomerController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/profile")
    public String getCustomerProfile() {
        // This is a placeholder for fetching customer profile details
        return "Customer profile details";
    }

    @GetMapping("/orders")
    public String getCustomerOrders() {
        // This is a placeholder for fetching customer orders
        return "Customer order details";
    }

    @PostMapping("/send-message")
    public ResponseEntity<Message> sendMessageToCustomer(@RequestBody MessageDTO messageDTO) {
        // Convert the DTO to an entity
        Message message = new Message();
        message.setCustomerId(messageDTO.getCustomerId());
        message.setContent(messageDTO.getContent());
        message.setTimestamp(messageDTO.getTimestamp());
        message.setUser(User.CUSTOMER); // Set user type explicitly

        // Save the message in the DB
        Message savedMessage = messageRepository.save(message);

        // Return the saved entity
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/messages/{email}")
    public ResponseEntity<List<Message>> getMessagesByEmail(@PathVariable("email") String email) {
        // Find messages by customer email
        List<Message> messages = messageRepository.findByCustomerId(email);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    // Update an existing message by its ID
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") Long id,
                                                 @RequestBody MessageDTO updatedMessageDTO) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            // Update only fields you wish to allow changes to
            message.setContent(updatedMessageDTO.getContent());
            message.setTimestamp(updatedMessageDTO.getTimestamp());
            message.setUser(User.CUSTOMER); // Maintain user type on update
            Message savedMessage = messageRepository.save(message);
            return new ResponseEntity<>(savedMessage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a message by its ID
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable("id") Long id) {
        try {
            messageRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
