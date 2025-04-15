package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.model.Category;
import edu.sandhanu.ecom.model.OrderDetailsDTO;
import edu.sandhanu.ecom.service.custom.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class AnalysisController {

    @Autowired
    private final AnalysisService analysisSerivce;

    @GetMapping("/items/count")
    public ResponseEntity<Integer> getTotalItemsCount(@RequestParam Long customerId) {
        return ResponseEntity.ok(analysisSerivce.getTotalItemsCount(customerId));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(analysisSerivce.getAllCategories());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDetailsDTO>> getOrderDetails(@RequestParam Long customerId) {
        return ResponseEntity.ok(analysisSerivce.getOrderDetails(customerId));
    }

}
