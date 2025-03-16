package edu.sandhanu.ecom.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname("0.0.0.0"); // Must be 0.0.0.0 for external access
        config.setPort(9092);

        // Add these headers for WebSocket handshake
        config.setAuthorizationListener(data -> {
            data.getHttpHeaders().add("Access-Control-Allow-Origin", "http://localhost:5173");
            data.getHttpHeaders().add("Access-Control-Allow-Headers", "*");
            data.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
            return true;
        });

        // Add these parameters for connection stability
        config.setUpgradeTimeout(10000);
        config.setPingInterval(25000);
        config.setPingTimeout(60000);

        // Enable WebSocket transport only
        config.setTransports(Transport.WEBSOCKET);

        return new SocketIOServer(config);
    }
}