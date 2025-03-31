package edu.sandhanu.ecom.controller;


import edu.sandhanu.ecom.model.Message;

import edu.sandhanu.ecom.service.custom.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {
    @Autowired
    private  MessageService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleChatMessage(@Valid Message message) {
        message.setTimestamp(System.currentTimeMillis());
        return messageService.save(message);
    }

    @MessageMapping("/chat/update")
    @SendTo("/topic/messages")
    public Message handleMessageUpdate(Message messageDTO) {
        Message existing = messageService.findById(messageDTO.getId());

        if (!existing.getCustomerId().equals(messageDTO.getCustomerId())) {
            throw new SecurityException("Unauthorized message update");
        }

        existing.setContent(messageDTO.getContent());
        existing.setTimestamp(System.currentTimeMillis());

        return messageService.save(existing);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Long>> getAllCustomerIds() {
        List<Message> messages = messageService.findAll();
        List<Long> customerIds = messages.stream()
                .map(Message::getCustomerId)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerIds);
    }

    @GetMapping("/chat/{customerId}")
    public ResponseEntity<List<Message>> getCustomerChat(@PathVariable Long customerId) {
        List<Message> messages = messageService.findByCustomerId(customerId);
        return ResponseEntity.ok(messages);
    }
    @MessageMapping("/message/delete")
    @SendTo("/topic/messages")
    public Long deleteMessage(Long id) {
        messageService.deleteById(id);
        return id;
    }

    @GetMapping("CustomerIdByEmail")
    public ResponseEntity<Integer> getCustomerIdByEmail(String email) {
        return ResponseEntity.ok(messageService.getCustomerIdByEmail(email));
    }
}