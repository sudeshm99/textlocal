
package javaBeen;

import java.sql.PreparedStatement;
import databasePackage.database;
import java.sql.Connection;
import java.sql.ResultSet;

public class sendMessage {
    database connectDB = new database();
    public sendMessage() {
        
    }
    
    public void checkMessage(String meter, String units){
        getReading(meter);
    }
    
    public int getReading(String meter){
        //String meter_no = meter;
        int meter_no = Integer.parseInt(meter);
        int reading = 0;
        int current_units = 0;
        try{
           String sql = "SELECT current_reading,current_units FROM meter WHERE meter_no=?; ";
           Connection myConnection = connectDB.connection();
           PreparedStatement statement = myConnection.prepareStatement(sql);
           statement.setInt(1,meter_no);
           ResultSet result = statement.executeQuery();
           
            while(result.next()){
                reading = result.getInt("current_reading");
                current_units = result.getInt("current_units");
            }
            return current_units;
        }catch(Exception ex){
            ex.getMessage();
           
        }
        return 0;
        }
    public void setReding(){
    
    }
    
}
