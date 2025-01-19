package ASimulatorSystem;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Ministatements extends JFrame{
    JLabel mini,bank,card,rupee;
    String pinnumber;
    
    Ministatements(String pinnumber){
        setLayout(null);
        setTitle("Ministatements");
        setLayout(null);
        
        mini = new JLabel();
        mini.setFont(new Font("raleway",Font.BOLD,14));
        mini.setBounds(20,80,400,200);
        add(mini);

        bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Raleway",Font.BOLD,18));
        bank.setBounds(185,20,200,20);
        add(bank);

        card = new JLabel();
        card.setFont(new Font("raleway",Font.BOLD,14));
        card.setBounds(20,80,300,20);
        add(card);

        

        try{
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("select * from login where pin = '1976'");
             while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + "Rs." + rs.getString("cardnumber").substring(12));
             }

        } catch(Exception e){
            System.out.println(e);
        }

         try{
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("select * from bank where pin = '1976'");
             while(rs.next()){
                mini.setText(mini.getText() + "<html>" + "&nbsp;&nbsp;" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp&nbsp;" + rs.getString("amount") + "<br> <html>");
             }

        } catch(Exception e){
            System.out.println(e);
        }


        setSize(500,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String args[]){
       new Ministatements("");
    }
}