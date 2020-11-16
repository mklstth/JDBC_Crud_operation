package com.mthree.daos;

import java.sql.Connection;
import java.sql.SQLException;

public interface UpdateDAO {
    int updateStockWithID(Connection con, int id, String newName) throws SQLException;
}
