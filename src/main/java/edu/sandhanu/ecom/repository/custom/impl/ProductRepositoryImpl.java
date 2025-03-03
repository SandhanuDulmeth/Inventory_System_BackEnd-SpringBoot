package edu.sandhanu.ecom.repository.custom.impl;


import edu.sandhanu.ecom.entity.ProductEntity;
import edu.sandhanu.ecom.repository.custom.ProductRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public ArrayList<ProductEntity> gettAll() {
        ArrayList<ProductEntity> productEntities =new ArrayList<>();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM PRODUCT;");
            while (resultSet.next()) {
                productEntities.add(new ProductEntity(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                ));
            }
            return productEntities.isEmpty() ? null : productEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
