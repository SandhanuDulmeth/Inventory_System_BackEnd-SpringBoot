package edu.sandhanu.ecom.model;

import java.time.LocalDateTime;

public record OrderDetailsDTO(
    Long orderId,
    LocalDateTime orderDate,
    Double totalAmount,
    String status,
    Integer productId,
    String productName,
    Integer quantity,
    Double unitPrice
) {}