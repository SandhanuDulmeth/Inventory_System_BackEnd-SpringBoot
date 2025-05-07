package edu.sandhanu.ecom.service.custom;

import edu.sandhanu.ecom.model.Customer;

import java.util.List;

public interface CustomerService {

    Boolean checkCustomerByEmail(String email);

    Boolean checkCustomerPasswordByEmail(String email, String password);

    Integer  getCustomerIdByEmail(String email);
    List<Customer> getAllCustomers();
    Boolean updateCustomer(Long id, Customer customer);
    Boolean deleteCustomer(Long id);
}
