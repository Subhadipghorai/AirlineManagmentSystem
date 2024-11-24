package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class Home  extends JFrame implements ActionListener{
        public Home(){
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/image/front.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,1300,650);
            add(image);

            JLabel hading = new JLabel("WELCOME TO AIR INDIA");
            hading.setBounds(430,40,1000,40);
            hading.setForeground(Color.blue);
            hading.setFont(new Font("Taunt",Font.ITALIC,36));
            image.add(hading);

            JMenuBar menubar = new JMenuBar();
            setJMenuBar(menubar);

            JMenu details = new JMenu("Details");
            menubar.add(details);

            JMenuItem flightDetails = new JMenuItem("FlightDetails");
            flightDetails.addActionListener(this);
            details.add(flightDetails);

            JMenuItem customerDetails = new JMenuItem("Add Customer Details");
            customerDetails.addActionListener(this);
            details.add(customerDetails);

            JMenuItem bookFlight = new JMenuItem("Book Flight");
            bookFlight.addActionListener(this);
            details.add(bookFlight);

            JMenuItem journeyDetails = new JMenuItem("Journey Details");
            journeyDetails.addActionListener(this);
            details.add(journeyDetails);

            JMenuItem ticketCancellation = new JMenuItem("Ticket Cancel");
            ticketCancellation.addActionListener(this);
            details.add(ticketCancellation);



            JMenu ticket= new JMenu("Ticket");
            menubar.add(ticket);

            JMenuItem boardingPass = new JMenuItem("Boarding Pass");
            ticket.add(boardingPass);





            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocation(450,230);
            setVisible(true);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = e.getActionCommand();

            if (text.equals("Add Customer Details")){
                new AddCustomer();

            }else if(text.equals("FlightDetails")){
                new FlightInfo();
            }
            else if(text.equals("Book Flight")) {
                new BookFlight();
            }
            else if(text.equals("Journey Details")) {
                new JourneyDetails();
            } else if (text.equals("Ticket Cancel")) {
                new Cancel();

            }


        }

        public static void main(String[] args) {
            new Home();

        }

    }
