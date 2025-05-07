package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.model.Customer;
import edu.sandhanu.ecom.service.custom.AdminService;

import edu.sandhanu.ecom.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final CustomerService customerService;

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkAdminByEmail(@RequestParam String email) {
        return ResponseEntity.ok(adminService.checkAdminByEmail(email));
    }

    @GetMapping("/check-password")
    public ResponseEntity<Boolean> checkAdminPasswordByEmail(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(adminService.checkAdminPasswordByEmail(email, password));    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Boolean> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

}
