package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.repository.custom.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryAnalysisService {
    private final ItemRepository itemRepository;

    public InventoryMetrics calculateMetrics(Long customerId) {
        try {
            int totalItems = itemRepository.countAllItems(customerId);
            int lowStockItems = itemRepository.countLowStockItems(10, customerId);
            double totalValue = itemRepository.calculateTotalValue(customerId);
            int categories = itemRepository.countDistinctCategories(customerId);

            return new InventoryMetrics(totalItems, lowStockItems, totalValue, categories);
        } catch (Exception e) {

         log.error("Error calculating metrics for customer {}", customerId, e);
            throw e;
        }
    }


    public record InventoryMetrics(
            int totalItems,
            int lowStockItems,
            double totalValue,
            int categories

    ) {}
}
