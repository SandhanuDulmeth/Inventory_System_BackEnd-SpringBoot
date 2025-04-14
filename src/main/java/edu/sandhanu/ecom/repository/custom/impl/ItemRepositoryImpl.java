package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.repository.custom.ItemRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public int countAllItems(Long customerId) {
        try (ResultSet resultSet = CrudUtil.executeQuery(
                "SELECT COUNT(*) AS count FROM Product WHERE customer_id = ?",
                customerId
        )) {
            return resultSet.next() ? resultSet.getInt("count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count items", e);
        }
    }

    @Override
    public int countLowStockItems(int threshold, Long customerId) {
        try (ResultSet resultSet = CrudUtil.executeQuery(
                "SELECT COUNT(*) AS count FROM Product WHERE stock_quantity < ? AND customer_id = ?",
                threshold, customerId
        )) {
            return resultSet.next() ? resultSet.getInt("count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count low stock items", e);
        }
    }

    @Override
    public double calculateTotalValue(Long customerId) {
        try (ResultSet resultSet = CrudUtil.executeQuery(
                "SELECT SUM(price * stock_quantity) AS total_value FROM Product WHERE customer_id = ?",
                customerId
        )) {
            return resultSet.next() ? resultSet.getDouble("total_value") : 0.0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to calculate total value", e);
        }
    }

    @Override
    public int countDistinctCategories(Long customerId) {
        try (ResultSet resultSet = CrudUtil.executeQuery(
                "SELECT COUNT(DISTINCT category_id) AS category_count FROM Product WHERE customer_id = ?",
                customerId
        )) {
            return resultSet.next() ? resultSet.getInt("category_count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count categories", e);
        }
    }
}
