package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private MessageRepository messageRepository;





}
