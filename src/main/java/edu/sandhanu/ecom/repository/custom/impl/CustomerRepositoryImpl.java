package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.repository.custom.CustomerRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

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


}
