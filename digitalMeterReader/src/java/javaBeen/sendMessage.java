
package javaBeen;

import java.sql.PreparedStatement;
import databasePackage.database;
import java.sql.Connection;
import java.sql.ResultSet;

public class sendMessage {
    database connectDB = new database();
    public sendMessage() {
        
    }
    
    public void checkMessage(String meter, String voltage, String ampire ){
        
    }
    
    public int getReding(String meter){
        //String meter_no = meter;
        int meter_no = Integer.parseInt(meter);
        int reding = 0;
        int units = 0;
        try{
           String sql = "SELECT current_reading,current_units FROM meter WHERE meter_no=?; ";
          Connection myConnection = connectDB.connection();
         PreparedStatement statement = myConnection.prepareStatement(sql);
         statement.setInt(1,meter_no);
            ResultSet result = statement.executeQuery();
           
            while(result.next()){
                reding = result.getInt("current_reading");
                units = result.getInt("current_units");
            }
            return reding;
        }catch(Exception ex){
            ex.getMessage();
           
        }
        return 0;
        }
    public void setReding(){
    
    }
    
}
