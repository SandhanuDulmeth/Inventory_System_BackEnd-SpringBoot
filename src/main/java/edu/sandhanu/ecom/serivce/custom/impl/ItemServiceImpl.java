package edu.sandhanu.ecom.serivce.custom.impl;


import edu.sandhanu.ecom.model.Product;
import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.serivce.custom.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ItemServiceImpl implements ProductService {

private final ProductRepository productRepository;

    private final ModelMapper mapper;



    @Override
    public ArrayList<Product> getProduct() {
        ArrayList<Product> products = new ArrayList<>();
        productRepository.gettAll().forEach(product -> products.add(mapper.map(product, Product.class)));

        return products;
    }
}
