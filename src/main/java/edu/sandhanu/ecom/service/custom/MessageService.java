package edu.sandhanu.ecom.service.custom;

import edu.sandhanu.ecom.entity.MessageEntity;
import edu.sandhanu.ecom.model.Message;


import java.util.List;

public interface MessageService {
    Integer getCustomerIdByEmail(String customerId);

    //    List<Message> findByCustomerId(String customerId);
//    Message save(Message message);
//
//
//    void deleteById(Long id);
//
//
//    Message findById(Long id);
//
//    List<Message> findAll();
List<Message> findByCustomerId(Long customerId);
    Message save(Message message);
    void deleteById(Long id);
    Message findById(Long id);
    List<Message> findAll();


}
