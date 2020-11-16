package com.mthree.services;

import com.mthree.daos.UpdateDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateService implements UpdateDAO {

    /**
     * Method to update a Stock element given by it's ID to a new Name
     * @param connection, the DB connection
     * @param id the Stock ID
     * @param newName the new name we want to give to the stock with given ID
     * @return If this number is greater than or equal to zero, it indicates the update count returned by the statement. If it is -1, it indicates that there are no more results.
     * @throws SQLException
     */
    @Override
    public int updateStockWithID(Connection connection, int id, String newName) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "UPDATE stock " +
                "SET sname = '"+newName+"' WHERE s_id = "+id;
        return stmt.executeUpdate(sql);
    }
}
