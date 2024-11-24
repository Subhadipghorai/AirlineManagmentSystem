package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfName,tfPhone,tfAadhaar,tfNationality,tfAddress;
    JRadioButton rbMale,rbFemale,rbOther;

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
        tfName = new JTextField();
        tfName.setBounds(220,80,150,25);
        add(tfName);


        JLabel lblNationality = new JLabel("Nationality ");
        lblNationality.setBounds(60,130,150,25);
        lblNationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblNationality);
        tfNationality = new JTextField();
        tfNationality.setBounds(220,130,150,25);
        add(tfNationality);

        JLabel lblAadhaar = new JLabel("Aadhaar Number ");
        lblAadhaar.setBounds(60,180,150,25);
        lblAadhaar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAadhaar);
        tfAadhaar = new JTextField();
        tfAadhaar.setBounds(220,180,150,25);
        add(tfAadhaar);

        JLabel lblAddress = new JLabel("Address ");
        lblAddress.setBounds(60,220,150,25);
        lblAddress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblAddress);
        tfAddress = new JTextField();
        tfAddress.setBounds(220,220,150,25);
        add(tfAddress);

        JLabel lblGender = new JLabel("Gender ");
        lblGender.setBounds(60,270,150,25);
        lblGender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblGender);

        ButtonGroup genderGroup= new ButtonGroup();

        rbMale =new JRadioButton("Male");
        rbMale.setBounds(220,270,70,25);
        rbMale.setBackground(Color.white);
        add(rbMale);

        rbFemale =new JRadioButton("Female");
        rbFemale.setBounds(300,270,70,25);
        rbFemale.setBackground(Color.white);
        add(rbFemale);

        rbOther =new JRadioButton("Other");
        rbOther.setBounds(380,270,70,25);
        rbOther.setBackground(Color.white);
        add(rbOther);

        JLabel lblPhone = new JLabel(" Phone ");
        lblPhone.setBounds(60,330,150,25);
        lblPhone.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblPhone);
        tfPhone = new JTextField();
        tfPhone.setBounds(220,330,150,25);
        add(tfPhone);

        JButton Save = new JButton("SAVE");
        Save.setBackground(Color.BLACK);
        Save.setForeground(Color.WHITE);
        Save.setBounds(220,380,150,30);
        Save.addActionListener(this);
        add(Save);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/image/emp.png"));
        JLabel lblImage =new JLabel(image);
        lblImage.setBounds(450,80,280,400);
        add(lblImage);


        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);





        setSize(900,600);
        setLocation(300,150);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String name = tfName.getText();
        String nationality = tfNationality.getText();
        String address = tfAddress.getText();
        String phone = tfPhone.getText();
        String aadhaar = tfAadhaar.getText();

        String gender = null;
        if(rbMale.isSelected()){
            gender ="Male";
        } else if (rbFemale.isSelected()) {
            gender ="Female";
        }
        else{
            gender = "Other";
        }
        try{
            Conn conn = new Conn();
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhaar+"', '"+gender+"')";


            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details added Successfully");
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
