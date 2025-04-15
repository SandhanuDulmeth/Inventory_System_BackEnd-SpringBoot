package edu.sandhanu.ecom.service.custom.impl;



import edu.sandhanu.ecom.model.Category;
import edu.sandhanu.ecom.model.OrderDetailsDTO;
import edu.sandhanu.ecom.repository.custom.CategoryRepository;
import edu.sandhanu.ecom.repository.custom.ItemRepository;
import edu.sandhanu.ecom.repository.custom.OrderRepository;
import edu.sandhanu.ecom.service.custom.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;

    @Override
    public int getTotalItemsCount(Long customerId) {
        return itemRepository.countAllItems(customerId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<OrderDetailsDTO> getOrderDetails(Long customerId) {
        return orderRepository.findOrdersWithItems(customerId);
    }
}
