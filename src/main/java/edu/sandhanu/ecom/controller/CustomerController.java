package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.repository.custom.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // Enable CORS for this controller
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private  MessageRepository messageRepository;

    public CustomerController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/profile")
    public String getCustomerProfile() {

        return "Customer profile details";
    }

    @GetMapping("/orders")
    public String getCustomerOrders() {

        return "Customer order details";
    }







}
