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


}
