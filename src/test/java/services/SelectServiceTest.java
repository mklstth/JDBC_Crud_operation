package services;

import com.mthree.models.DatabaseConnection;
import com.mthree.services.SelectService;
import org.junit.*;

import java.sql.*;

/** 
* SelectService Tester. 
* 
* @author Miklós Tóth
* @since <pre>Sep 25, 2020</pre> 
* @version 1.0 
*/ 
public class SelectServiceTest {

    static SelectService selectService;

/** 
* 
* Method: selectAllRecordFromStock(Connection con, String element) 
* 
*/ 
    @Test
    public void testSelectAllRecordFromStock() throws Exception {
        selectService = new SelectService();
    DatabaseConnection databaseConnection = null;
    try {
        databaseConnection = DatabaseConnection.getInstance();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Connection connection = databaseConnection.getConnection();

    ResultSet rsAll = selectService.selectAllRecordFromStock(connection);

    Assert.assertNotNull(rsAll);
        while(rsAll.next()) {
            if (rsAll.getInt("s_id") == 123) {
                Assert.assertEquals(123, rsAll.getInt("s_id"));
                Assert.assertEquals("test", rsAll.getString("sname"));
            } else {
                continue;
            }
        }
    }
}

