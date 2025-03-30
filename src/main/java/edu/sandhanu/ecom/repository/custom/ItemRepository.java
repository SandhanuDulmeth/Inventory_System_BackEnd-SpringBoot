package edu.sandhanu.ecom.repository.custom;

public interface ItemRepository {
    int countAllItems(Long customerId);
    int countLowStockItems(int threshold, Long customerId);
    double calculateTotalValue(Long customerId);
    int countDistinctCategories(Long customerId);
}
