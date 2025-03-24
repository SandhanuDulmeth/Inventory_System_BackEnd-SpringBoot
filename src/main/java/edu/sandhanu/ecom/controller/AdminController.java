package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.service.custom.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<Boolean> checkAdminByEmail(@RequestParam String email) {
        return ResponseEntity.ok(adminService.checkAdminByEmail(email));
    }





}
