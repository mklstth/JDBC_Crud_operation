package services;

import com.mthree.models.DatabaseConnection;
import com.mthree.services.UpdateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.sql.SQLException;

/** 
* UpdateService Tester. 
* 
* @author Miklós Tóth
* @since <pre>Sep 28, 2020</pre> 
* @version 1.0 
*/ 
public class UpdateServiceTest {

    UpdateService updateService;

/** 
* 
* Method: updateStockWithID(Connection connection, int id, String newName) 
* 
*/ 
@Test
public void testUpdateStockWithID() throws Exception {
    updateService = new UpdateService();
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    int response = updateService.updateStockWithID(connection, 123, "testName");

    Assert.assertEquals(1, response);
} 


} 
