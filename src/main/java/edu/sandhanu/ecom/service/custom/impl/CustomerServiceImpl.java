package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.model.Customer;
import edu.sandhanu.ecom.repository.custom.CustomerRepository;
import edu.sandhanu.ecom.service.custom.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Boolean checkCustomerByEmail(String email) {
        return customerRepository.checkCustomerByEmail(email);
    }

    @Override
    public Boolean checkCustomerPasswordByEmail(String email, String password) {
        return customerRepository.checkCustomerPasswordByEmail(email, password);
    }

    @Override
    public Integer getCustomerIdByEmail(String email) {
        return customerRepository.getCustomerIdByEmail(email);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public Boolean updateCustomer(Long id, Customer customer) {
        return customerRepository.update(id, customer);
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        return customerRepository.delete(id);
    }



}
