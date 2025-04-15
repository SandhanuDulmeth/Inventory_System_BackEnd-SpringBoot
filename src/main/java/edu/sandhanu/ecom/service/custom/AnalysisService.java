package edu.sandhanu.ecom.service.custom;

import edu.sandhanu.ecom.model.Category;
import edu.sandhanu.ecom.model.OrderDetailsDTO;

import java.util.List;

public interface AnalysisService {
    int getTotalItemsCount(Long customerId);
    List<Category> getAllCategories();
    List<OrderDetailsDTO> getOrderDetails(Long customerId);
}
