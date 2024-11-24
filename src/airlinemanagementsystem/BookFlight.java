package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tfAadhaar;
    JLabel tfName,tfNationality,tfAddress, labelGender,lblFlightName,lblFlightCode;
    JButton bookFlight,fetchButton,flight;
    Choice source,destination;
    JDateChooser dcDate;


    public  BookFlight(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(400,20,500,40);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblAadhaar = new JLabel("Aadhaar");
        lblAadhaar.setBounds(60,80,150,25);
        lblAadhaar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAadhaar);
        tfAadhaar = new JTextField();
        tfAadhaar.setBounds(220,80,150,25);
        add(tfAadhaar);

        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,125,25);
        fetchButton.addActionListener(this);
        add(fetchButton);


        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60,130,150,25);
        lblName.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblName);
        tfName= new JLabel();
        tfName.setBounds(220,130,150,25);
        add(tfName);


        JLabel lblNationality = new JLabel("Nationality ");
        lblNationality.setBounds(60,180,150,25);
        lblNationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblNationality);
        tfNationality = new JLabel();
        tfNationality.setBounds(220,180,150,25);
        add(tfNationality);


        JLabel lblAddress = new JLabel("Address ");
        lblAddress.setBounds(60,230,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAddress);
        tfAddress = new JLabel();
        tfAddress.setBounds(220,230,150,25);
        add(tfAddress);


        JLabel lblGender = new JLabel("Gender ");
        lblGender.setBounds(60,280,150,25);
        add(lblGender);

        labelGender =new JLabel("Gender");
        labelGender.setBounds(220,280,150,25);
        add(labelGender);



        JLabel lblSource = new JLabel("Source ");
        lblSource.setBounds(60,330,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblSource);

        source = new Choice();
        source.setBounds(220,330,150,25);
        add(source);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(60,380,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblDestination);

        destination = new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);

        try{
            Conn c = new Conn();
            String query ="select * from flight";
           ResultSet rs= c.s.executeQuery(query);

           while(rs.next()){
               source.add(rs.getString("source"));
               destination.add(rs.getString("destination"));
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        flight = new JButton("Fetch Flight");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);

        JLabel lblDate = new JLabel("Date of Travel");
        lblDate.setBounds(60,430,150,25);
        lblDate.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblDate);

        dcDate=new JDateChooser();
        dcDate.setBounds(220,430,150,25);
        add(dcDate);

        JLabel lblF_name = new JLabel("Flight Name");
        lblF_name.setBounds(60,480,150,25);
        lblF_name.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblF_name);

        lblFlightName =new JLabel();
        lblFlightName.setBounds(220,480,150,25);
        add(lblFlightName);


        JLabel lblF_code = new JLabel("Flight Code");
        lblF_code.setBounds(60,530,150,25);
        lblF_code.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblF_code);

        lblFlightCode =new JLabel();
        lblFlightCode.setBounds(220,530,150,25);
        add(lblFlightCode);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/image/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
        ImageIcon image =new ImageIcon(i2);
        JLabel lblImage =new JLabel(image);
        lblImage.setBounds(550,80,500,410);
        add(lblImage);

        bookFlight = new JButton("Book Flight");
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBounds(220,580,150,25);
        bookFlight.addActionListener(this);
        add(bookFlight);



        setSize(1050,900);
        setLocation(80,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== fetchButton){
            String Aadhar = tfAadhaar.getText();

        try{
            Conn conn = new Conn();
            String query = "select * from passenger where Aadhar = '"+Aadhar+"'";
            ResultSet rs =conn.s.executeQuery(query);

            if(rs.next()){
                tfName.setText(rs.getString("name"));
                tfNationality.setText(rs.getString("nationality"));
                tfAddress.setText(rs.getString("address"));
                labelGender.setText(rs.getString("gender"));
            }
            else{
                JOptionPane.showMessageDialog(null,"User data dose not exist please enter correct aadhaar");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }
        }
        else if(ae.getSource()== flight) {

            String src = source.getSelectedItem();
            String dest =destination.getSelectedItem();

            try{
                Conn conn = new Conn();
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
                ResultSet rs =conn.s.executeQuery(query);

                if(rs.next()){
                    lblFlightName.setText(rs.getString("flight_name"));
                    lblFlightCode.setText(rs.getString("flight_code"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Flight Available");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else {
            Random random = new Random();
            String aadhar =tfAadhaar.getText();
            String name =tfName.getText();
            String nationality=tfNationality.getText();
            String f_name=lblFlightName.getText();
            String f_code =lblFlightCode.getText();
            String src =source.getSelectedItem();
            String des =destination.getSelectedItem();
            String ddate =((JTextField)dcDate.getDateEditor().getUiComponent()).getText();

            try{
                Conn conn = new Conn();
                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+f_name+"','"+f_code+"','"+src+"','"+des+"','"+ddate+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Ticket Book Successfully");

                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new BookFlight();
    }
}
