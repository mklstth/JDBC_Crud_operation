package com.mthree.services;

import com.mthree.daos.SelectDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectService implements SelectDAO {

    /**
     * Method to select all the elements from the table Stock
     * @param con the DB connection
     * @return the ResultSet with all the elements of the Stock table
     * @throws SQLException
     */
    @Override
    public ResultSet selectAllRecordFromStock(Connection con) throws SQLException {
        return con.createStatement().executeQuery("SELECT * from stock");
    }


    /**
     * Method to select all the elements from the table Stock
     * @param con the DB connection
     * @param element with this you can narrow the search to element given in this String
     * @return the ResultSet with all the matching elements of the Stock table
     * @throws SQLException
     */
    @Override
    public ResultSet selectRecordFromStock(Connection con, String element) throws SQLException {
        return con.createStatement().executeQuery("SELECT "+ element +" from stock");
    }
}
