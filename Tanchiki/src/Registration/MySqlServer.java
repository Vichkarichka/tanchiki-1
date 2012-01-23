/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlServer 
{
    Connection connect;
    Statement stmt;
    public MySqlServer()
    {
        try
        {
            String drivername = "com.mysql.jdbc.Driver";
            Class.forName(drivername);
            
            connect = DriverManager.getConnection
                    ("jdbc:mysql://localhost/new_schema","root","1111");
            stmt = connect.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
