package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.entity.MessageEntity;
import edu.sandhanu.ecom.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity> {


    List<MessageEntity> findByCustomerId(Long customerId);
    Integer getCustomerIdByEmail(String email);
    MessageEntity save(MessageEntity map);

    void deleteById(Long id);

    MessageEntity findById(Long id);

    List<MessageEntity> findAll();
}

