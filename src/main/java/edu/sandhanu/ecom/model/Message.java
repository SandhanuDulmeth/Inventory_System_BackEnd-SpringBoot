package edu.sandhanu.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.sandhanu.ecom.util.SenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @JsonIgnore
    private Long id;
    private Long customerId;
    private String content;
    private Long timestamp;
    private SenderType senderType;


    public Message(Long customerId, String content, Long timestamp, SenderType senderType) {
        this.customerId = customerId;
        this.content = content;
        this.timestamp = timestamp;
        this.senderType = senderType;
    }
}

