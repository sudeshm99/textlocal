
package databasePackage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class database {
    
    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection =DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalMeter", "root", "1234");
            //Connection myConnection =DriverManager.getConnection("jdbc:mysql://br-cdbr-azure-south-b.cloudapp.net:3306/smart_rms","b50735a87d1621","8a720e5f");
            //System.ou t.println("DB.DBConnection.connection()");
            return myConnection;
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            //System.err.println(ex);
        }
        return null;
    }    
}


