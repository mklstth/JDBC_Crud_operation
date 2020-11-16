package com.mthree.services;

import com.mthree.daos.DeleteDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteService implements DeleteDAO {

    /**
     * Method to delete a Stock given by it's ID
     * @param connection the DB connection
     * @param id the ID of the Stock that we would like to delete
     * @return If this number is greater than or equal to zero, it indicates the update count returned by the statement. If it is -1, it indicates that there are no more results.
     * @throws SQLException
     */
    @Override
    public int deleteStockWithID(Connection connection, int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "DELETE FROM stock " +
                "WHERE s_id = " + id;
        return stmt.executeUpdate(sql);
    }

    /**
     * Method to delete a Order given by it's ID
     * @param connection the DB connection
     * @param id the ID of the Order that we would like to delete
     * @return If this number is greater than or equal to zero, it indicates the update count returned by the statement. If it is -1, it indicates that there are no more results.
     * @throws SQLException
     */
    @Override
    public int deleteOrderWithID(Connection connection, int id) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "DELETE FROM orders " +
                "WHERE o_id = " + id;
        return stmt.executeUpdate(sql);
    }
}
