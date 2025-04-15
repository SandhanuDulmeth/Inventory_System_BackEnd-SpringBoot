package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.model.OrderDetailsDTO;

import java.util.List;

public interface OrderRepository {
    List<OrderDetailsDTO> findOrdersWithItems(Long customerId);
}
