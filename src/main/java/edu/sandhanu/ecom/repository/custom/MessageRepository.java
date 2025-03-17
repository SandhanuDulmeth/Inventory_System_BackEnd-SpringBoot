package edu.sandhanu.ecom.repository.custom;


import edu.sandhanu.ecom.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
