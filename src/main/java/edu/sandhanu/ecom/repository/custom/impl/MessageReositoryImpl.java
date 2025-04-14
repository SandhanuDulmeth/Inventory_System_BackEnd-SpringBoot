package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.entity.MessageEntity;
import edu.sandhanu.ecom.repository.custom.MessageRepository;
import edu.sandhanu.ecom.util.CrudUtil;
import edu.sandhanu.ecom.util.SenderType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageReositoryImpl implements MessageRepository {
    @Override
    public ArrayList<MessageEntity> gettAll() {
        return null;
    }

    @Override
    public List<MessageEntity> findByCustomerId(Long customerId) {
        try {
            if (customerId != null) {
                return getMessagesByCustomerId(customerId);
            }
            return new ArrayList<>();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
@Override
    public Integer getCustomerIdByEmail(String email)  {
    ResultSet customerResult = null;
    try {
        customerResult = CrudUtil.executeQuery("SELECT id FROM Customer WHERE email = ?", email);
        if (customerResult.next()) {
            return customerResult.getInt(1);
        }
        return null;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }

    private List<MessageEntity> getMessagesByCustomerId(Long customerId) throws SQLException {
        ResultSet messageResult = CrudUtil.executeQuery("SELECT * FROM Message WHERE customer_id = ?", customerId);
        ArrayList<MessageEntity> messages = new ArrayList<>();
        while (messageResult.next()) {
            String senderTypeStr = messageResult.getString("sender_type");

            SenderType senderType = (senderTypeStr != null) ? SenderType.valueOf(senderTypeStr) : null;
            
            messages.add(new MessageEntity(
                    messageResult.getLong("id"),
                    messageResult.getLong("customer_id"),
                    messageResult.getString("content"),
                    messageResult.getLong("timestamp"),
                    senderType
            ));
        }
        return messages;
    }

    @Override
    public MessageEntity save(MessageEntity map) {
        try {
            int id = CrudUtil.executeUpdate("INSERT INTO Message (customer_id, content, timestamp, sender_type) VALUES (?, ?, ?, ?)",
                    map.getCustomerId(), map.getContent(), map.getTimestamp(), 
                    map.getSenderType() != null ? map.getSenderType().toString() : null);
            map.setId((long) id);
            return map;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            CrudUtil.executeUpdate("DELETE FROM Message WHERE id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public MessageEntity findById(Long id) {
        try {
           ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Message WHERE id = ?", id);
           if(resultSet.next()){
               String senderTypeStr = resultSet.getString("sender_type");
               SenderType senderType = (senderTypeStr != null) ? SenderType.valueOf(senderTypeStr) : null;
               
               return new MessageEntity(
                       resultSet.getLong("id"),
                       resultSet.getLong("customer_id"),
                       resultSet.getString("content"),
                       resultSet.getLong("timestamp"),
                       senderType
               );
           }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MessageEntity> findAll() {
        List<MessageEntity> messages = new ArrayList<>();
        try (ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Message")) {
            while (resultSet.next()) {
                String senderTypeStr = resultSet.getString("sender_type");
                SenderType senderType = SenderType.valueOf(senderTypeStr); // No null check needed

                messages.add(new MessageEntity(
                        resultSet.getLong("id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getString("content"),
                        resultSet.getLong("timestamp"),
                        senderType
                ));
            }
        } catch (SQLException e) {
            // Log the exception or handle it appropriately
            throw new RuntimeException("Error retrieving messages", e);
        } catch (IllegalArgumentException e) {
            // Handle invalid sender_type values from the database
            throw new RuntimeException("Invalid sender type in database", e);
        }
        return messages;
    }
}
