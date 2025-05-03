package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.entity.SupplierEntity;
import edu.sandhanu.ecom.repository.custom.SupplierRepository;
import edu.sandhanu.ecom.util.CrudUtil;
import edu.sandhanu.ecom.util.SupplierStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierRepositoryImpl implements SupplierRepository {

    @Override
    public ArrayList<SupplierEntity> gettAll() {
        ArrayList<SupplierEntity> suppliers = new ArrayList<>();
        try {
            ResultSet rs = CrudUtil.executeQuery("SELECT * FROM suppliers");
            while (rs.next()) {
                suppliers.add(new SupplierEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("contact_person"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        SupplierStatus.valueOf(rs.getString("status")),
                        rs.getTimestamp("date_added").toLocalDateTime()
                ));
            }
            return suppliers.isEmpty() ? null : suppliers;
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching suppliers", e);
        }
    }

    @Override
    public SupplierEntity save(SupplierEntity entity) {
        try {
            ResultSet generatedKeys = CrudUtil.executeInsert(
                    "INSERT INTO suppliers (name, contact_person, email, phone, address, status) VALUES (?, ?, ?, ?, ?, ?)",
                    entity.getName(),
                    entity.getContactPerson(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getAddress(),
                    entity.getStatus().toString()
            );

            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt(1));
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving supplier", e);
        }
    }
}
