package services;

import com.mthree.models.DatabaseConnection;
import com.mthree.services.InsertService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.sql.SQLException;

/** 
* InsertService Tester. 
* 
* @author Miklós Tóth
* @since <pre>Sep 25, 2020</pre> 
* @version 1.0 
*/ 
public class InsertServiceTest {

    InsertService insertService;

/** 
* 
* Method: insertIntoStock(Connection con, int id, String name) 
* 
*/ 
@Test
public void testInsertIntoStock() throws Exception {

    insertService = new InsertService();
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    int response = insertService.insertIntoStock(connection, 123, "test");

    Assert.assertEquals(1, response);
} 

/** 
* 
* Method: insertIntoOrder(Connection con, int o_id, int s_id, int quantity, int price) 
* 
*/ 
@Test
public void testInsertIntoOrder() throws Exception {

    insertService = new InsertService();
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    int response = insertService.insertIntoOrder(connection, 234, 1, 10,200 );

    Assert.assertEquals(1, response);
} 


} 
