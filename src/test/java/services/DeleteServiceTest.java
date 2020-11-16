package services;

import com.mthree.models.DatabaseConnection;
import com.mthree.services.DeleteService;
import com.mthree.services.SelectService;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** 
* DeleteService Tester. 
* 
* @author Miklós Tóth
* @since <pre>Sep 25, 2020</pre> 
* @version 1.0 
*/ 
public class DeleteServiceTest {
    static DeleteService deleteService;
@BeforeClass
public static void before() throws Exception {
    deleteService = new DeleteService();
//
//    DatabaseConnection databaseConnection = null;
//    try {
//        databaseConnection = DatabaseConnection.getInstance();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    Connection connection = databaseConnection.getConnection();
//    PreparedStatement pst = connection.prepareStatement("INSERT into orders(o_id,s_id,size,price) VALUES(?,?,?,?)");
//
//    pst.setInt(1, 123);
//    pst.setInt(2, 12345);
//    pst.setInt(3, 123);
//    pst.setInt(4, 123);
//
//    pst.executeUpdate();
} 

/** 
* 
* Method: deleteOrderWithID(Connection connection, int id) 
* 
*/ 
@Test
public void testDeleteOrderWithID() throws Exception {
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    int response = deleteService.deleteOrderWithID(connection, 234);

    Assert.assertEquals(1, response);
}

@Test
public void testDeleteStockWithID() throws Exception {
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    int response = deleteService.deleteStockWithID(connection, 123);

    Assert.assertEquals(1, response);
}


} 
