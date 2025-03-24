package edu.sandhanu.ecom.entity;


import edu.sandhanu.ecom.util.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Creates a no-argument constructor
@AllArgsConstructor
@Entity
@Table(name = "Message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;  // Should match DTO

    @Lob
    private String content;     // Enable multiline storage
    private Long timestamp;

    @Enumerated(EnumType.STRING)
    private User user;
}
