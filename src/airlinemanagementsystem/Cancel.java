package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {
    JTextField tfpnr;
    JLabel tfName,Cancellation,lblfCode, lblDateOfTravel;
    JButton fetchButton,flight;


    public  Cancel(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        Random random =new Random();

        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        add(heading);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/image/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);

        JLabel lblAadhaar = new JLabel("PNR Number");
        lblAadhaar.setBounds(60,80,150,25);
        lblAadhaar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAadhaar);
        tfpnr = new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,125,25);
        fetchButton.addActionListener(this);
        add(fetchButton);


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60,130,150,25);
        lblName.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblName);
        tfName= new JLabel();
        tfName.setBounds(220,130,150,25);
        add(tfName);


        JLabel lblCancellation = new JLabel("Cancellation Number ");
        lblCancellation.setBounds(60,180,150,25);
        lblCancellation.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblCancellation);

        Cancellation = new JLabel(""+random.nextInt(100000));
        Cancellation.setBounds(220,180,150,25);
        add(Cancellation);


        JLabel lblFlightCode = new JLabel("FlightCode ");
        lblFlightCode.setBounds(60,230,150,25);
        lblFlightCode.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblFlightCode);

        lblfCode = new JLabel();
        lblfCode.setBounds(220,230,150,25);
        add(lblfCode);


        JLabel lblGender = new JLabel("Date ");
        lblGender.setBounds(60,280,150,25);
        add(lblGender);

        lblDateOfTravel =new JLabel();
        lblDateOfTravel.setBounds(220,280,150,25);
        add(lblDateOfTravel);

        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,25);
        flight.addActionListener(this);
        add(flight);


        setSize(800,450);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== fetchButton){
            String pnr = tfpnr.getText();

            try{
                Conn conn = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"'";
                ResultSet rs =conn.s.executeQuery(query);

                if(rs.next()){
                    tfName.setText(rs.getString("name"));
                    lblfCode.setText(rs.getString("flightcode"));
                    lblDateOfTravel.setText(rs.getString("ddate"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter correct PNR");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== flight) {

            String name = tfName.getText();
            String pnr =tfpnr.getText();
            String cancelNo = Cancellation.getText();
            String fcode = lblfCode.getText();
            String date = lblDateOfTravel.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelNo+"' ,'"+fcode+"','"+date+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR ='"+pnr+"'");

                JOptionPane.showMessageDialog(null,"Ticket Cancelled");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        new Cancel();
    }
}
