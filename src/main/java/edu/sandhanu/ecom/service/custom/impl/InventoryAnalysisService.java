package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.repository.custom.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryAnalysisService {
    private final ItemRepository itemRepository;



    public InventoryMetrics calculateMetrics() {
        int totalItems = itemRepository.countAllItems();
        int lowStockItems = itemRepository.countLowStockItems(10);
        double totalValue = itemRepository.calculateTotalValue();
        int categories = itemRepository.countDistinctCategories();

        return new InventoryMetrics(totalItems, lowStockItems, totalValue, categories);
    }

    public record InventoryMetrics(
            int totalItems,
            int lowStockItems,
            double totalValue,
            int categories
    ) {}
}