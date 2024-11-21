package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    public  AddCustomer(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(270,20,500,35);
        heading.setFont(new Font("Taunt",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);


        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(60,80,150,25);
        lblName.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblName);
        JTextField tfName = new JTextField();
        tfName.setBounds(220,80,150,25);
        add(tfName);


        JLabel lblNationality = new JLabel("Nationality: ");
        lblNationality.setBounds(60,130,150,25);
        lblNationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblNationality);
        JTextField tfNationality = new JTextField();
        tfNationality.setBounds(220,130,150,25);
        add(tfNationality);

        JLabel lblAadhaar = new JLabel("Aadhaar Number: ");
        lblAadhaar.setBounds(60,180,150,25);
        lblAadhaar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAadhaar);
        JTextField tfAadhaar = new JTextField();
        tfAadhaar.setBounds(220,180,150,25);
        add(tfAadhaar);

        JLabel lblAddress = new JLabel("Address: ");
        lblAddress.setBounds(60,220,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAddress);
        JTextField tfAddress = new JTextField();
        tfAddress.setBounds(220,220,150,25);
        add(tfAddress);

        JLabel lblGender = new JLabel("Gender: ");
        lblGender.setBounds(60,270,150,25);
        lblGender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblGender);

        ButtonGroup genderGroup= new ButtonGroup();

        JRadioButton rbMale =new JRadioButton("Male");
        rbMale.setBounds(220,270,70,25);
        rbMale.setBackground(Color.white);
        add(rbMale);

        JRadioButton rbFemale =new JRadioButton("Female");
        rbFemale.setBounds(300,270,70,25);
        rbFemale.setBackground(Color.white);
        add(rbFemale);

        JRadioButton rbOther =new JRadioButton("Other");
        rbOther.setBounds(380,270,70,25);
        rbOther.setBackground(Color.white);
        add(rbOther);

        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);





        setSize(900,600);
        setLocation(300,150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
