package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.model.Customer;
import edu.sandhanu.ecom.repository.custom.CustomerRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Boolean checkCustomerByEmail(String email) {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT EXISTS (SELECT 1 FROM Customer WHERE email=?)", email);
            if (resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean checkCustomerPasswordByEmail(String email, String password) {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT EXISTS (SELECT 1 FROM Customer WHERE email = ? AND password = ?)", email, password);
            if (resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Integer getCustomerIdByEmail(String email) {
        try {
            ResultSet resultSet = CrudUtil.executeQuery(
                    "SELECT id FROM Customer WHERE email = ?",
                    email
            );
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Customer> getAll() {
        try {
            ResultSet rs = CrudUtil.executeQuery("SELECT * FROM Customer");
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean update(Long id, Customer customer) {
        try {
            return 0>CrudUtil.executeUpdate(
                    "UPDATE Customer SET email=?, password=? WHERE id=?",
                    customer.getEmail(),
                    customer.getPassword(),
                    id
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            return 0>CrudUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
