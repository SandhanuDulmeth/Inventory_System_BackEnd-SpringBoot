package edu.sandhanu.ecom.config;


import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.repository.custom.impl.ProductRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
    @Bean
    public ProductRepository   productRepository () {return new ProductRepositoryImpl();
    }
    @Bean
    public ModelMapper getModelMapper () {
        return new ModelMapper();
    }



}
