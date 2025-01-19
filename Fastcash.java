package ASimulatorSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    JButton first,second,third,fourth,fifth,sixth,exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount:");
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setBounds(200,250,300,30);
        text.setForeground(Color.white);
        image.add(text);

        first = new JButton("Rs 100");
        first.setBounds(170,280,100,30);
        first.setBackground(Color.white);
        first.addActionListener(this);
        add(first);

        second = new JButton("Rs 500");
        second.setBounds(320,280,100,30);
        second.setBackground(Color.white);
        second.addActionListener(this);
        add(second);

        third = new JButton("Rs 1000");
        third.setBounds(165,330,110,30);
        third.setBackground(Color.white);
        third.addActionListener(this);
        add(third);

        fourth = new JButton("Rs 2000");
        fourth.setBounds(315,330,110,30);
        fourth.setBackground(Color.white);
        fourth.addActionListener(this);
        add(fourth);

        fifth = new JButton("Rs 5000");
        fifth.setBounds(165,380,110,30);
        fifth.setBackground(Color.white);
        fifth.addActionListener(this);
        add(fifth);

        sixth = new JButton("Rs 10000");
        sixth.setBounds(310,380,125,30);
        sixth.setBackground(Color.white);
        sixth.addActionListener(this);
        add(sixth);

        exit = new JButton("Back");
        exit.setBounds(340,440,100,30);
        exit.setBackground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == exit){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
       } else{
        String amount = ((JButton)ae.getSource()).getText().substring(3);
        Conn conn = new Conn(); 
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    return ;
                }

               Date date = new Date();
               String query8 ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
               conn.s.executeUpdate(query8);
               JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully." );
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
       }
    }
    public static void main(String args[]){
       new Fastcash("");
    }
}
