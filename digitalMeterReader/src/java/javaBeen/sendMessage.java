
package javaBeen;

import java.sql.PreparedStatement;
import databasePackage.database;
import java.sql.Connection;
import java.sql.ResultSet;
import packageSendSMS.sendSMS;

public class sendMessage {
    database connectDB = new database();
    public sendMessage() {
        
    }
    
    public void send(String meter, int units, int reading , int current_units){// check if we want to send message or not and
        //if we need send messag get message from table 
            sendSMS sendsms = new sendSMS();
            String message = null;
            int new_units = current_units + units;
            if(current_units<25 && new_units>=25){
              message =  getMessage(1);//get message from database
              
            }else if(current_units<50 && new_units>=50){
               message = getMessage(3);
            }else if(current_units<80 && new_units>=80){
              message = getMessage(5);
            }
            
    }
    
    public void getReading(String meter, int units){// get reading and current units using meter id executing sql query
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
            send(meter,units,reading,current_units);//using meter_id,current_reading,current_units and cunsumtion call send funtion
        }catch(Exception ex){
            ex.getMessage();
           
        }
        
        }
    public void setReding(){
    
    }
    public String getMessage(int id){// get message from database
        String message = null;
        try{
            String sql = "SELECT send_message FROM message WHERE message_id=?;";
            Connection myConnection = connectDB.connection();
            PreparedStatement statement = myConnection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                message = result.getString("send_message");
            }
            return message;
        }catch(Exception ex){
            ex.getMessage();
        }
     return null;   
    }
    public int getPhoneNumber(int meter){//get phone number from database
    
    return 0;
    }
}
