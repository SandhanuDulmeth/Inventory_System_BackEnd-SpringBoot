package edu.sandhanu.ecom.repository.custom.impl;


import edu.sandhanu.ecom.entity.ProductEntity;
import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.util.Category;
import edu.sandhanu.ecom.util.CrudUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Slf4j
public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public ArrayList<ProductEntity> gettAll() {
        ArrayList<ProductEntity> productEntities =new ArrayList<>();
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM PRODUCT;");
            while (resultSet.next()) {
                productEntities.add(new ProductEntity(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)
                ));

            }

            return productEntities.isEmpty() ? null : productEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        try {
            // Use the new executeInsert(...) method
            ResultSet generatedKeys = CrudUtil.executeInsert(
                    "INSERT INTO PRODUCT (name, description, price, stock_quantity, category_id) VALUES (?, ?, ?, ?, ?)",
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getQuantity(),
                    entity.getCategoryId()
            );

            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt(1)); 
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving product", e);
        }
    }
}
