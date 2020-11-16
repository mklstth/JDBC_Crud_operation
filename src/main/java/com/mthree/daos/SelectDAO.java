package com.mthree.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface SelectDAO {
    ResultSet selectRecordFromStock(Connection con, String e) throws SQLException;
    ResultSet selectAllRecordFromStock(Connection con) throws SQLException;
}
