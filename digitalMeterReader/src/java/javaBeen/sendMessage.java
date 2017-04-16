
package javaBeen;

import java.sql.PreparedStatement;
import databasePackage.database;
import java.sql.Connection;
import java.sql.ResultSet;
import packageSendSMS.sendSMS;

public class sendMessage {
    database connectDB = new database();
   
    
    public void checkSending(String meter, int units, int reading , int current_units){// check if we want to send message or not and
        //if we need send messag get message from table 
           int new_reading = reading + units;
            
            int new_units = current_units + units;
            
            if(current_units<25 && new_units>=25){
                 send(1,meter);
              
            }else if(current_units<50 && new_units>=50){
                 send(3,meter);

            }else if(current_units<80 && new_units>=80){
                 send(5,meter);

            }
            setReading(meter, new_reading,new_units);
            
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
            checkSending(meter,units,reading,current_units);//using meter_id,current_reading,current_units and cunsumtion call checkSending funtion
        }catch(Exception ex){
            ex.getMessage();
           
        }
        
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
    public String getPhoneNumber(String meter){//get phone number from database
        String number = null;
        
        try{
            String sql = "SELECT contact_no FROM user WHERE meter_no=?;";
            Connection myConnection = connectDB.connection();
            PreparedStatement statement = myConnection.prepareStatement(sql);
            statement.setString(1,meter);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                number = result.getString("contact_no");
            }
            return number;
        }catch(Exception ex){
            ex.getMessage();
        }
    return null;
    }
    public void send(int num,String meter){// send message using textlocal
        String message = null;
        String number = null;
        
        message = getMessage(num);
        number = getPhoneNumber(meter);
        
//        String massage = request.getParameter("massage");
//        String number = request.getParameter("number");
        String universalNumber = "94" + number.substring(1);
        
        sendSMS sendsms = new sendSMS();
        sendsms.sendSms(message, universalNumber);
    }
    public void setReading(String meter, int reading, int units){//enter new reading to database
          try{
            String sql = "UPDATE meter SET current_reading=?,current_units=? WHERE meter_no=?;";
            Connection myConnection = connectDB.connection();
            PreparedStatement statement = myConnection.prepareStatement(sql);
            statement.setInt(1,reading);
            statement.setInt(2,units);
            statement.setString(3,meter);
            statement.execute();
                  }catch(Exception ex){
            ex.getMessage();
        }
    }
}
