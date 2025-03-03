package edu.sandhanu.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Creates a no-argument constructor
@AllArgsConstructor // Optional: Provides a constructor for all fields
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}

