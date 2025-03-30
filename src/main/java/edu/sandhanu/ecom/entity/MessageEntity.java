package edu.sandhanu.ecom.entity;


import edu.sandhanu.ecom.util.SenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "customer_id")
    private Long customerId;

    @Lob
    private String content;
    private Long timestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "sender_type", length = 10)
    private SenderType senderType;


}
