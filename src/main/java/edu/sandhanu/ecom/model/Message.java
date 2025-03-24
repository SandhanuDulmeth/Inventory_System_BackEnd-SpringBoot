package edu.sandhanu.ecom.model;

import edu.sandhanu.ecom.util.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;
    private String customerId;  // Changed from Long to String to match email
    private String content;
    private Long timestamp;
    private User user;


    public Message(String customerId, String content, Long timestamp, User user) {
        this.customerId = customerId;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
    }
}

