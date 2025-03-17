package edu.sandhanu.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsGlobalConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // Allow your client origin
        config.addAllowedOrigin("http://localhost:5173");
        // If using cookies, tokens, or HTTP Basic
        config.setAllowCredentials(true);
        // Allowed methods and headers
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        // Expose any headers needed on the client side
        config.addExposedHeader("Authorization");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}