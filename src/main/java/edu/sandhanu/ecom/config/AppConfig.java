package edu.sandhanu.ecom.config;


import edu.sandhanu.ecom.repository.custom.AdminRepository;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.repository.custom.impl.AdminRepositoryImpl;
import edu.sandhanu.ecom.repository.custom.impl.ProductRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
