package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByCustomerId(String customerId);
}
