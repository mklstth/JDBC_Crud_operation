package com.mthree;

import com.mthree.controllers.CRUDController;
import com.mthree.models.DatabaseConnection;
import com.mthree.models.Stock;
import com.mthree.services.DeleteService;
import com.mthree.services.InsertService;
import com.mthree.services.SelectService;
import com.mthree.services.UpdateService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connection connection = databaseConnection.getConnection();

        /*
        Creation of the controller to drive the whole application and all the services.
         */
        CRUDController crudController = new CRUDController(new SelectService(), new InsertService(), new DeleteService(), new UpdateService());


        /*
        Population of the Order table, the commented out parts only need to run once, if we want to see more elements in the table
        the last line of creation stays to prove that is is working. We are deleting that entry in the next block.
         */
        try {
//            crudController.insertOrder(connection, 1, 1, 123, 20);
//            crudController.insertOrder(connection, 2, 1, 123, 20);
//            crudController.insertOrder(connection, 3, 1, 123, 20);
            crudController.insertOrder(connection, 42, 1, 123, 20);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        Deleting the last Order entry, created in the previous block to test it's working.
         */
        try {
            crudController.deleteOrderByID(connection, 42);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        Inserting  a few new Stocks to the DB given ID, and Name, the commented out part is just to have some variety at the first run.
        the Stock with id 13 will be deleted.
         */
        try {
//            crudController.insertStockByIDName(connection, 1, "Apple");
//            crudController.insertStockByIDName(connection, 2, "Microsoft");
//            crudController.insertStockByIDName(connection, 3, "Samsung");
//            crudController.insertStockByIDName(connection, 4, "LG");
            crudController.insertStockByIDName(connection, 13, "Google");
        } catch (SQLException e) {
            System.out.println("The insertion failed do to already existing data with similar Primary Key");
        }

        /*
        Reading out all the Stocks from the stocks table
         */
        try {
            ResultSet rs = crudController.selectAllStocks(connection);
            while(rs.next()){
                System.out.println("ID "+rs.getString("s_id")+" Name "+rs.getString("sname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         /*
        Updating a Stock name given by it's ID
         */
        try {
            int i = crudController.updateStockByID(connection, 13, "Facebook");
        } catch (SQLException e) {
            System.out.println("The update of the employee with ID 13 was unsuccessful");
        }
        try {
            ResultSet rs = crudController.selectAllStocks(connection);
            while(rs.next()){
                System.out.println("ID "+rs.getString("s_id")+" Name "+rs.getString("sname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
        Deleting a stock given by it's ID
         */
        try {
            int i = crudController.deleteStockByID(connection, 13);
        } catch (SQLException e) {
            System.out.println("The deletion of the employee with ID 13 was unsuccessful");
        }


        /*
        Reading back Stocks to memory from the DB
         */
        ArrayList<Stock> stocks = new ArrayList<>();
        try {
            ResultSet rs = crudController.selectAllStocks(connection);
            while(rs.next()){
                Stock s = new Stock(rs.getString("sname"), rs.getInt("s_id"));
                System.out.println(s.toString());
                stocks.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**
         * The Test methods use the same DB connection as the Main application. Therefor primary and foreign key collisions can happen.
         * The right order of the test is to run them is:
         *      1, InsertServiceTest, to have some elements in the DB to work on
         *      2, UpdateServiceTest, to change the name of one of the test elements.
         *      3, SelectServiceTest, to see that we are able to select element in the tables.
         *      4, Delete ServiceTest, to Delete all the unwanted test data from the DB.
         */


    }
}
