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







}
