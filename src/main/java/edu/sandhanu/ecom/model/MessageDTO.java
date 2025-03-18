package edu.sandhanu.ecom.model;

import edu.sandhanu.ecom.util.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private String customerId;  // Changed from Long to String to match email
    private String content;
    private Long timestamp;
    private User user;
}