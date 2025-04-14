package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.entity.AdminEntity;
import edu.sandhanu.ecom.repository.custom.AdminRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public ArrayList<AdminEntity> gettAll() {
        return null;
    }

    @Override
    public Boolean checkAdminByEmail(String email) {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT EXISTS (SELECT 1 FROM Admin WHERE email=?)", email);
            if (resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean checkAdminPasswordByEmail(String email, String password) {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT EXISTS (SELECT 1 FROM Admin WHERE email = ? AND password = ?)", email, password);
            if (resultSet.next()) {
                return resultSet.getBoolean(1);
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
