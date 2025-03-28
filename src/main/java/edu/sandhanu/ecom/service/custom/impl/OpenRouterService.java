package edu.sandhanu.ecom.service.custom.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenRouterService {

    @Value("${spring.ai.openai.base-url}")
    private String baseUrl;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OpenRouterService() {
        this.restTemplate = new RestTemplate();
    }

    public String generateResponse(String prompt) {
        String url = baseUrl + "/chat/completions";
        
        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("HTTP-Referer", "http://localhost:8080");
        headers.set("X-Title", "Inventory System AI");
        
        // Create message
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);
        
        // Create request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "mistralai/mistral-7b-instruct:free");
        requestBody.put("messages", List.of(message));
        
        // Create HTTP entity
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        
        try {
            // Make POST request
            Map<String, Object> response = restTemplate.postForObject(url, entity, Map.class);
            
            // Extract response content
            if (response != null && response.containsKey("choices")) {
                List<?> choices = (List<?>) response.get("choices");
                if (!choices.isEmpty()) {
                    Map<?, ?> choice = (Map<?, ?>) choices.get(0);
                    Map<?, ?> responseMessage = (Map<?, ?>) choice.get("message");
                    return (String) responseMessage.get("content");
                }
            }
            return "No response generated";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}