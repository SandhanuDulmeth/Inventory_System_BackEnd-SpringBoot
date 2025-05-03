package edu.sandhanu.ecom.config;


import edu.sandhanu.ecom.model.Category;
import edu.sandhanu.ecom.repository.custom.*;
import edu.sandhanu.ecom.repository.custom.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    public AdminRepository adminRepository() {
        return new AdminRepositoryImpl();
    }

    @Bean
    public ItemRepository itemRepository() {
        return new ItemRepositoryImpl();
    }

    @Bean
    public MessageRepository messageRepository() {
        return new MessageReositoryImpl();
    }

    @Bean
    public CategoryRepository categoryRepository() {return new CategoryRepositoryImpl();}

    @Bean
    public OrderRepository orderRepository(){return new OrderRepositoryImpl();}

    @Bean
    public CustomerRepository customerRepository(){return new CustomerRepositoryImpl();}

    @Bean
    public SupplierRepository supplierRepository(){return new SupplierRepositoryImpl();}



    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
