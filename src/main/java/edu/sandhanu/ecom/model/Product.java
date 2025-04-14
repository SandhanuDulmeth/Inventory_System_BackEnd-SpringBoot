package edu.sandhanu.ecom.model;

import edu.sandhanu.ecom.util.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Integer categoryId;
}

