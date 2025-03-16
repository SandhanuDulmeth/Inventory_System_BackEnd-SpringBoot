package edu.sandhanu.ecom.controller;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import edu.sandhanu.ecom.entity.Message;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketIOController {
    private final SocketIOServer server;
    private final MessageRepository messageRepository;

    @Autowired
    public SocketIOController(SocketIOServer server, MessageRepository messageRepository) {
        this.server = server;
        this.messageRepository = messageRepository;
    }

    @OnEvent("message")
    public void onMessage(SocketIOClient client, String messageContent) {
        // Save to database
        Message message = new Message();
        message.setContent(messageContent);
        messageRepository.save(message);

        // Broadcast to all clients
        server.getBroadcastOperations().sendEvent("message", messageContent);
    }
}