package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.entity.MessageEntity;
import edu.sandhanu.ecom.model.Message;
import edu.sandhanu.ecom.repository.custom.MessageRepository;

import edu.sandhanu.ecom.service.custom.MessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper mapper;


    @Override
    public List<Message> findByCustomerId(String customerId) {
        List<MessageEntity> byCustomerId = messageRepository.findByCustomerId(customerId);
        List<Message> mappedMessages = new ArrayList<>();
       byCustomerId.forEach(entity -> {
           mappedMessages.add(mapper.map(entity, Message.class));
        });
        return mappedMessages;
    }


    @Override
    public Message save(Message message) {
        return mapper.map(messageRepository.save(mapper.map(message, MessageEntity.class)), Message.class);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message findById(Long id) {
        MessageEntity messageNotFound = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        return mapper.map(messageNotFound, Message.class);

    }

    @Override
    public List<Message> findAll() {
        List<MessageEntity> allMessages = messageRepository.findAll();
        List<Message> mappedMessages = new ArrayList<>();
       allMessages.forEach(entity -> mappedMessages.add(mapper.map(entity, Message.class)));
        return mappedMessages;

    }

}
