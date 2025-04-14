package edu.sandhanu.ecom.service.custom;


import edu.sandhanu.ecom.model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getProduct();
    Product createProduct(Product product);
}