package edu.sandhanu.ecom.repository.custom.impl;

import edu.sandhanu.ecom.model.OrderDetailsDTO;
import edu.sandhanu.ecom.repository.custom.AnaliysisRepository;
import edu.sandhanu.ecom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnaliysisRepositoryImpl implements AnaliysisRepository {
    @Override
    public List<OrderDetailsDTO> findOrdersWithItems(Long customerId) {
        String query = "SELECT o.id, o.order_date, o.total_amount, o.status, " +
                "oi.product_id, p.name AS product_name, oi.quantity, oi.unit_price " +
                "FROM Orders o " +
                "JOIN Order_Item oi ON o.id = oi.order_id " +
                "JOIN Product p ON oi.product_id = p.id " +
                "WHERE o.customer_id = ?";

        try (ResultSet rs = CrudUtil.executeQuery(query, customerId)) {
            List<OrderDetailsDTO> orders = new ArrayList<>();
            while (rs.next()) {
                orders.add(new OrderDetailsDTO(
                        rs.getLong("id"),
                        rs.getTimestamp("order_date").toLocalDateTime(),
                        rs.getDouble("total_amount"),
                        rs.getString("status"),
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price")
                ));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch order details", e);
        }
    }
}
