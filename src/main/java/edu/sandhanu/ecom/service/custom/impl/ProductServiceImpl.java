package edu.sandhanu.ecom.service.custom.impl;


import edu.sandhanu.ecom.entity.ProductEntity;
import edu.sandhanu.ecom.model.Product;
import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.service.custom.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;


    @Override
    public ArrayList<Product> getProduct() {
        ArrayList<Product> products = new ArrayList<>();
        productRepository.gettAll().forEach(product -> products.add(mapper.map(product, Product.class)));
        return products;
    }

    @Override
    public Product createProduct(Product product) {

        ProductEntity entity = mapper.map(product, ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(entity);
        return mapper.map(savedEntity, Product.class);
    }

}
