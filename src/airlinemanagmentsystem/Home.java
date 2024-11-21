package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class Home  extends JFrame implements ActionListener{
        public Home(){
            setLayout(null);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/image/front.jpg"));
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
            details.add(flightDetails);

            JMenuItem customerDetails = new JMenuItem("Add Customer Details");
            details.add(customerDetails);

            JMenuItem reservationDetails = new JMenuItem("Customer Reservation Details");
            details.add(reservationDetails);

            JMenuItem bookFlight = new JMenuItem("Book Flight");
            details.add(bookFlight);

            JMenuItem journeyDetails = new JMenuItem("journey Details");
            details.add(journeyDetails);

            JMenuItem ticketCancellation = new JMenuItem("ticket Cancel ");
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




        }

        public static void main(String[] args) {
            new Home();

        }

    }
