package ASimulatorSystem;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java .awt.*;

public class Balance_enquiry  extends JFrame implements ActionListener{
    JLabel image,text,bal;
    JButton back;
    String pinnumber;
    Balance_enquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        back = new JButton("Back");
        back.setBounds(300,380,100,30);
        back.addActionListener(this);
        add(back);

        int balance = 0;
        Conn conn = new Conn(); 
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }

        text = new JLabel("Your Current Balance:");
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(175,220,300,30);
        image.add(text);

        bal = new JLabel("You current account balance is Rs. " + balance);
        bal.setForeground(Color.white);
        bal.setBounds(150,250,300,30);
        image.add(bal);


        setSize(700,700 );
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
       }
    }
       
       public static void main(String args[]){
        new Balance_enquiry("");
    }
}


