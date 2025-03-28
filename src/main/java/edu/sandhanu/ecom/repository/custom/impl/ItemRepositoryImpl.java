package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.repository.custom.ItemRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public int countAllItems() {
        try (ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) AS count FROM Item")) {
            return resultSet.next() ? resultSet.getInt("count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count items", e);
        }
    }

    @Override
    public int countLowStockItems(int threshold) {
        try (ResultSet resultSet = CrudUtil.execute(
                "SELECT COUNT(*) AS count FROM Item WHERE stock_quantity < ?",
                threshold
        )) {
            return resultSet.next() ? resultSet.getInt("count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count low stock items", e);
        }
    }

    @Override
    public double calculateTotalValue() {
        try (ResultSet resultSet = CrudUtil.execute(
                "SELECT SUM(price * stock_quantity) AS total_value FROM Item"
        )) {
            return resultSet.next() ? resultSet.getDouble("total_value") : 0.0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to calculate total value", e);
        }
    }

    @Override
    public int countDistinctCategories() {
        try (ResultSet resultSet = CrudUtil.execute(
                "SELECT COUNT(DISTINCT category_id) AS category_count FROM Item"
        )) {
            return resultSet.next() ? resultSet.getInt("category_count") : 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count categories", e);
        }
    }
}
