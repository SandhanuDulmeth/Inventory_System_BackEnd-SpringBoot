package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * Fetches all messages by a particular customer
     * @param customerId the ID of the customer
     * @return list of messages by the customer
     */
    List<Message> findByCustomerId(Long customerId);
}
