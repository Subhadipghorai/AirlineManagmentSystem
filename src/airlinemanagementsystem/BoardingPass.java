package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;
public class BoardingPass extends JFrame implements ActionListener {
    JTextField tfpnr;
    JLabel tfName,tfNationality,lblSource, lbldest,lblFlightName,lblFlightCode, labelDate;
    JButton fetchButton;


    public  BoardingPass(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360,50,300,30);
        subheading.setFont(new Font("Tahuma",Font.PLAIN,24));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        JLabel lblAadhaar = new JLabel("PNR DETAILS");
        lblAadhaar.setBounds(60,100,150,25);
        lblAadhaar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAadhaar);
        tfpnr = new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);


        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60,140,150,25);
        lblName.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblName);
        tfName= new JLabel();
        tfName.setBounds(220,140,150,25);
        add(tfName);


        JLabel lblNationality = new JLabel("NATIONALITY");
        lblNationality.setBounds(60,180,150,25);
        lblNationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblNationality);
        tfNationality = new JLabel();
        tfNationality.setBounds(220,180,150,25);
        add(tfNationality);


        JLabel lblAddress = new JLabel("SOURCE");
        lblAddress.setBounds(60,220,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAddress);
        lblSource = new JLabel();
        lblSource.setBounds(220,220,150,25);
        add(lblSource);


        JLabel lblGender = new JLabel("DESTINATION");
        lblGender.setBounds(380,220,150,25);
        add(lblGender);

        lbldest =new JLabel();
        lbldest.setBounds(540,220,150,25);
        add(lbldest);


        JLabel lblF_name = new JLabel("Flight Name");
        lblF_name.setBounds(60,260,150,25);
        lblF_name.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblF_name);

        lblFlightName =new JLabel();
        lblFlightName.setBounds(220,260,150,25);
        add(lblFlightName);


        JLabel lblF_code = new JLabel("Flight Code");
        lblF_code.setBounds(380,260,150,25);
        lblF_code.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblF_code);

        lblFlightCode =new JLabel();
        lblFlightCode.setBounds(540,260,150,25);
        add(lblFlightCode);

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(60,300,150,25);
        lblDate.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblDate);

        labelDate=new JLabel();
        labelDate.setBounds(220,300,150,25);
        add(labelDate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/image/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300,230,Image.SCALE_DEFAULT);
        ImageIcon image =new ImageIcon(i2);
        JLabel lblImage =new JLabel(image);
        lblImage.setBounds(600,0,300,300);
        add(lblImage);

        setSize(1000,450);
        setLocation(150,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            String pnr = tfpnr.getText();

            try{
                Conn conn = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"'";
                ResultSet rs =conn.s.executeQuery(query);

                if(rs.next()){
                    tfName.setText(rs.getString("name"));
                    tfNationality.setText(rs.getString("nationality"));
                    lblSource.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    lblFlightName.setText(rs.getString("flightname"));
                    lblFlightCode.setText(rs.getString("flightcode"));
                    labelDate.setText(rs.getString("ddate"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter correct PNR");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        new BoardingPass();
    }
}
