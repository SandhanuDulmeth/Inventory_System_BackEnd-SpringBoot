package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.service.custom.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkAdminByEmail(@RequestParam String email) {
        return ResponseEntity.ok(adminService.checkAdminByEmail(email));
    }

    @GetMapping("/check-password")
    public ResponseEntity<Boolean> checkAdminPasswordByEmail(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(adminService.checkAdminPasswordByEmail(email, password));    }





}
