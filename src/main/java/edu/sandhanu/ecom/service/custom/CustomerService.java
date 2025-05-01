package edu.sandhanu.ecom.service.custom;

public interface CustomerService {

    Boolean checkCustomerByEmail(String email);

    Boolean checkCustomerPasswordByEmail(String email, String password);

    Integer  getCustomerIdByEmail(String email);
}
