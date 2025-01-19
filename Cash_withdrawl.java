package ASimulatorSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sql.*;

public class Cash_withdrawl extends JFrame implements ActionListener{
    JLabel text;
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Cash_withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setBounds(150,220,300,30);
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setBounds(160,250,250,30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway",Font.BOLD,16));
        withdraw.setBounds(150,300,130,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(300,300,130,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
               if(ae.getSource() == withdraw){
                String number = amount.getText();
                Date date = new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw.");
                } else{
                    JOptionPane.showMessageDialog(null, "Rs "+number+" cashwithdrawl successfully.");
                    try{
                        Conn conn = new Conn();
                        String query7 = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                        conn.s.executeUpdate(query7);
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    } catch(Exception e){
                        System.out.println(e);
                    }
                }
               } else if(ae.getSource() == back){
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
               }
        }
    
    public static void main(String args[]){
        new Cash_withdrawl("");
    }
}

