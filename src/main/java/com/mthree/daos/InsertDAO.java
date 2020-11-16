package com.mthree.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface InsertDAO {
    int insertIntoStock(Connection con, int id, String name) throws SQLException;
    int insertIntoOrder(Connection con, int id, int s_id, int price, int quantity) throws SQLException;

}
