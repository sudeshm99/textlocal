
package javaBeen;

import java.sql.PreparedStatement;
import databasePackage.database;
import java.sql.Connection;
import java.sql.ResultSet;

public class sendMessage {
    database connectDB = new database();
    public sendMessage() {
        
    }
    
    public void send(String meter, int units, int reading , int current_units){
            int new_units = current_units + units;
            if(current_units<25 && new_units)
    }
    
    public void getReading(String meter, int units){
       // String meter_no = meter;
        //int meter_no = Integer.parseInt(meter);
        int reading = 0;
        int current_units = 0;
        try{
           String sql = "SELECT current_reading,current_units FROM meter WHERE meter_no=?; ";
           Connection myConnection = connectDB.connection();
           PreparedStatement statement = myConnection.prepareStatement(sql);
           statement.setString(1,meter);
           ResultSet result = statement.executeQuery();
           
            while(result.next()){
                reading = result.getInt("current_reading");
                current_units = result.getInt("current_units");
            }
            send(meter,units,reading,current_units);
        }catch(Exception ex){
            ex.getMessage();
           
        }
        
        }
    public void setReding(){
    
    }
    
}
