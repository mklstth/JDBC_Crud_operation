package com.mthree.controllers;

import com.mthree.daos.DeleteDAO;
import com.mthree.daos.InsertDAO;
import com.mthree.daos.SelectDAO;
import com.mthree.daos.UpdateDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDController {
    SelectDAO selectDAO;
    InsertDAO insertDAO;
    DeleteDAO deleteDAO;
    UpdateDAO updateDAO;

    public CRUDController(SelectDAO selectDAO, InsertDAO insertDAO,DeleteDAO deleteDAO, UpdateDAO updateDAO) {
        this.selectDAO = selectDAO;
        this.insertDAO = insertDAO;
        this.deleteDAO = deleteDAO;
        this.updateDAO = updateDAO;
    }

    public ResultSet selectAllStocks(Connection con) throws SQLException {
        return selectDAO.selectAllRecordFromStock(con);
    }
    public ResultSet selectStocks(Connection con, String elem) throws SQLException {
        return selectDAO.selectRecordFromStock(con, elem);
    }

    public int insertStockByIDName(Connection cn, int id, String name) throws SQLException {
        return insertDAO.insertIntoStock(cn, id, name);
    }
    public int insertOrder(Connection cn, int id, int s_id, int price, int quantity) throws SQLException {
        return insertDAO.insertIntoOrder(cn, id, s_id, price, quantity);
    }

    public int deleteStockByID(Connection cn, int id) throws SQLException {
        return deleteDAO.deleteStockWithID(cn, id);
    }
    public int deleteOrderByID(Connection cn, int id) throws SQLException {
        return deleteDAO.deleteOrderWithID(cn, id);
    }

    public int updateStockByID(Connection cn, int id, String name) throws SQLException{
        return updateDAO.updateStockWithID(cn, id, name);
    }
}
