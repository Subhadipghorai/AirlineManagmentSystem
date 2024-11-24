package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JTable Table= new JTable();

        try{
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from flight");
            Table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(Table);
        jsp.setBounds(0,0,800,500);
        add(jsp);


        setSize(800,500);
        setLocation(400,200);
        setVisible(true);


    }
    public static void main(String[] args) {
        new FlightInfo();
    }
}
