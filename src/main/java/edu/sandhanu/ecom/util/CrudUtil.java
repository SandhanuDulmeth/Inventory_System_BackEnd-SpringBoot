package edu.sandhanu.ecom.util;

import edu.sandhanu.ecom.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrudUtil {

    private static final Logger logger = Logger.getLogger(CrudUtil.class.getName());

    public static ResultSet execute(String sql, Object... params) throws SQLException {
        logger.info("Executing Query: " + sql + " | Parameters: " + Arrays.toString(params));

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        setParameters(preparedStatement, params);
        return preparedStatement.executeQuery();
    }

    public static int executeUpdate(String sql, Object... params) throws SQLException {
        logger.info("Executing Update: " + sql + " | Parameters: " + Arrays.toString(params));

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            setParameters(preparedStatement, params);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQL Execution Failed", e);
            throw e;
        }
    }

    private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
    }
}
