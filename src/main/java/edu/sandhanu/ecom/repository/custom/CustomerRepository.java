package edu.sandhanu.ecom.repository.custom;

public interface CustomerRepository {
    Boolean checkCustomerByEmail(String email);

    Boolean checkCustomerPasswordByEmail(String email, String password);

    Integer getCustomerIdByEmail(String email);
}
