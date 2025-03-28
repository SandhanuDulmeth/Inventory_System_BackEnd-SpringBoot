package edu.sandhanu.ecom.repository.custom;

public interface ItemRepository {
    int countAllItems();

    int countLowStockItems(int i);

    double calculateTotalValue();

    int countDistinctCategories();
}
