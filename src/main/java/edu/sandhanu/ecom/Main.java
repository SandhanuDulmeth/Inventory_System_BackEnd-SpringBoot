package edu.sandhanu.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration.class
})
public class Main {
    public static void main(String[] args) {
             SpringApplication.run(Main.class, args);
    }
}