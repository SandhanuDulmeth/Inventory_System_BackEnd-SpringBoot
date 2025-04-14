package edu.sandhanu.ecom.util;

import edu.sandhanu.ecom.db.DBConnection;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudUtil {

    private static final Logger logger = Logger.getLogger(CrudUtil.class.getName());

    // For SELECT statements
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        logger.info("Executing Query: " + sql + " | Parameters: " + Arrays.toString(params));
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        setParameters(preparedStatement, params);
        return preparedStatement.executeQuery();
    }

    // For UPDATE/DELETE statements without needing generated keys
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        logger.info("Executing Update: " + sql + " | Parameters: " + Arrays.toString(params));

        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParameters(preparedStatement, params);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQL Execution Failed", e);
            throw e;
        }
    }

    // For INSERT statements when you need auto-generated keys
    public static ResultSet executeInsert(String sql, Object... params) throws SQLException {
        logger.info("Executing Insert: " + sql + " | Parameters: " + Arrays.toString(params));

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        setParameters(preparedStatement, params);
        preparedStatement.executeUpdate();

        // Return the row(s) of generated keys (e.g., auto-increment IDs)
        return preparedStatement.getGeneratedKeys();
    }

    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
    }
}
