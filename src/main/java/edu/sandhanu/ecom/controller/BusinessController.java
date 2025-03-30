package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.service.custom.MessageService;
import edu.sandhanu.ecom.service.custom.impl.InventoryAnalysisService;
import edu.sandhanu.ecom.service.custom.impl.OpenRouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessController {
    private final InventoryAnalysisService inventoryAnalysis;
    private final OpenRouterService openRouterService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/status/{customerId}")
    public ResponseEntity<String> getBusinessStatus(@PathVariable Long customerId) {
        try {
            InventoryAnalysisService.InventoryMetrics metrics = inventoryAnalysis.calculateMetrics(customerId);

            String prompt = String.format(
                    "Act as an inventory management expert. Generate a concise, friendly business status message " +
                            "for customer ID %d. Metrics: Total Items: %d, Low Stock: %d, Total Value: $%.2f, Categories: %d. " +
                            "Include customer-specific insights and suggestions. Keep it under 3 sentences.",
                    customerId,
                    metrics.totalItems(),
                    metrics.lowStockItems(),
                    metrics.totalValue(),
                    metrics.categories()
            );

            String aiResponse = openRouterService.generateResponse(prompt);
            return ResponseEntity.ok(aiResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Unable to generate status for customer: " + customerId);
        }
    }

    @GetMapping("CustomerIdByEmail")
    public ResponseEntity<Integer> getCustomerIdByEmail(String email) {
        return ResponseEntity.ok(messageService.getCustomerIdByEmail(email));
    }
}
