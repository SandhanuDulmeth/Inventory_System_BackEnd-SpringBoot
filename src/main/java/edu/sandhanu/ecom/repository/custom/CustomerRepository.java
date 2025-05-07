package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Boolean checkCustomerByEmail(String email);

    Boolean checkCustomerPasswordByEmail(String email, String password);

    Integer getCustomerIdByEmail(String email);
    List<Customer> getAll();
    Boolean update(Long id, Customer customer);
    Boolean delete(Long id);
}
