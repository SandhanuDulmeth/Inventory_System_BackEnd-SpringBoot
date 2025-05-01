package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // Enable CORS for this controller
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkCustomerByEmail(@RequestParam String email) {
        return ResponseEntity.ok(customerService.checkCustomerByEmail(email));
    }

    @GetMapping("/check-password")
    public ResponseEntity<Boolean> checkCustomerPasswordByEmail(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(customerService.checkCustomerPasswordByEmail(email, password));    }

    @GetMapping("/CustomerIdByEmail")
    public ResponseEntity<Integer> getCustomerIdByCustomer(@RequestParam String email){
        return ResponseEntity.ok(customerService.getCustomerIdByEmail(email));
    }

}
