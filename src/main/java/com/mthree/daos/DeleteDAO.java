package com.mthree.daos;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeleteDAO {
    int deleteStockWithID(Connection con, int id) throws SQLException;
    int deleteOrderWithID(Connection con, int id) throws SQLException;
}
