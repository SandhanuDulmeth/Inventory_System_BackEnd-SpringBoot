package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.service.custom.impl.OpenRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OpenRouterAIController {

    private final OpenRouterService openRouterService;

    @Autowired
    public OpenRouterAIController(OpenRouterService openRouterService) {
        this.openRouterService = openRouterService;
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestBody Map<String, Object> requestBody) {

        String question = ((Map<String, String>)((List<?>)requestBody.get("messages")).get(0)).get("content");

        return openRouterService.generateResponse(question);
    }
}
