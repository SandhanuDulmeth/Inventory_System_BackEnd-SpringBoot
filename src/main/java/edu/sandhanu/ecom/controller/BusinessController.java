package edu.sandhanu.ecom.controller;

import edu.sandhanu.ecom.service.custom.impl.InventoryAnalysisService;
import edu.sandhanu.ecom.service.custom.impl.OpenRouterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessController {
    private final InventoryAnalysisService inventoryAnalysis;
    private final OpenRouterService openRouterService;


    @GetMapping("/status")
    public ResponseEntity<String> getBusinessStatus() {
        try {
            InventoryAnalysisService.InventoryMetrics metrics = inventoryAnalysis.calculateMetrics();

            String prompt = String.format(
                    "Act as an inventory management expert. Generate a concise, friendly business status message " +
                            "using these metrics: Total Items: %d, Low Stock: %d, Total Value: $%.2f, Categories: %d. " +
                            "Highlight key insights, potential concerns, and suggestions. Keep it under 2 sentences.",
                    metrics.totalItems(),
                    metrics.lowStockItems(),
                    metrics.totalValue(),
                    metrics.categories()
            );

            String aiResponse = openRouterService.generateResponse(prompt);
            return ResponseEntity.ok(aiResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Unable to generate status at this time");
        }
    }
}