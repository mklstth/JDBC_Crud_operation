package com.mthree.services;

import com.mthree.daos.InsertDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertService implements InsertDAO {

    /**
     * Method to insert a new Stock to the stock table
     * @param con the DB connection
     * @param id the new stock's ID
     * @param name  the newly inserted stock's name
     * @return If this number is greater than or equal to zero, it indicates the update count returned by the statement. If it is -1, it indicates that there are no more results.
     * @throws SQLException
     */
    @Override
    public int insertIntoStock(Connection con, int id, String name) throws SQLException {

        PreparedStatement pst = con.prepareStatement("INSERT into stock(s_id,sname) VALUES(?,?)");

        pst.setInt(1, id); // Here 1 indicates first ?
        pst.setString(2, name);

        int i = pst.executeUpdate();

        return i;
    }


    /**
     * Method to insert a new Order to the orders table
     * @param con the DB connection
     * @param o_id the new orders's ID
     * @param s_id the new orders's stock ID
     * @param quantity the new orders's size
     * @param price  the newly inserted orders's price
     * @return If this number is greater than or equal to zero, it indicates the update count returned by the statement. If it is -1, it indicates that there are no more results.
     * @throws SQLException
     */
    @Override
    public int insertIntoOrder(Connection con, int o_id, int s_id,  int quantity, int price) throws SQLException {

        PreparedStatement pst = con.prepareStatement("INSERT into orders(o_id,s_id,size,price) VALUES(?,?,?,?)");

        pst.setInt(1, o_id);
        pst.setInt(2, s_id);
        pst.setInt(3, quantity);
        pst.setInt(4, price);

        int i = pst.executeUpdate();

        return i;
    }
}
