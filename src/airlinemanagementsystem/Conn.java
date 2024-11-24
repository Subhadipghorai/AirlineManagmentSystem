package airlinemanagementsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public  Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","subha859733..");
            s= c.createStatement();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
