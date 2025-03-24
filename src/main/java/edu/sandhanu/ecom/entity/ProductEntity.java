package edu.sandhanu.ecom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;



}












