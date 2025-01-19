package ASimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Signup3 extends JFrame implements ActionListener{
    JLabel text,accounttype,card,carddetails,number,pin,pindetails,pnumber,facility;
    JRadioButton saving,fixed,current,recurring;
    ButtonGroup typeGroup;
    JCheckBox ATM_card,netbanking,mobilebanking,message_alert,e_statements,chequebook,passbook,confirm;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setLayout(null);

        text = new JLabel("Page3: AccountsDetails ");
        text.setFont(new Font("Raleway",Font.BOLD,24));
        text.setBounds(260,20,700,40);
        add(text);

        accounttype = new JLabel("Account Type:");
        accounttype.setFont(new Font("Raleway",Font.BOLD,18));
        accounttype.setBounds(50,60,300,30);
        add(accounttype);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(50,100,150,30);
        saving.setBackground(Color.white);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(250,100,200,30);
        fixed.setBackground(Color.white);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setBounds(50,150,150,30);
        current.setBackground(Color.white);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(250,150,200,30);
        recurring.setBackground(Color.white);
        add(recurring);

        typeGroup = new ButtonGroup();
        typeGroup.add(saving);
        typeGroup.add(fixed);
        typeGroup.add(current);
        typeGroup.add(recurring);

        card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,18));
        card.setBounds(50,200,150,30);
        add(card);

        carddetails = new JLabel("(This is your Card Number)");
        carddetails.setFont(new Font("raleway",Font.BOLD,12));
        carddetails.setBounds(50,220,200,30);
        add(carddetails);

        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("raleway",Font.BOLD,14));
        number.setBounds(250,200,300,30);
        add(number);

        pin = new JLabel("Pin Number :");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(50,270,150,30);
        add(pin);

        pindetails = new JLabel("(This is your Pin Number)");
        pindetails.setFont(new Font("raleway",Font.BOLD,12));
        pindetails.setBounds(50,290,200,20);
        add(pindetails);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,14));
        pnumber.setBounds(250,270,300,30);
        add(pnumber);

        facility = new JLabel("Services:");
        facility.setFont(new Font("raleway",Font.BOLD,18));
        facility.setBounds(50,320,200,30);
        add(facility);

        ATM_card = new JCheckBox("Issue ATM Card");
        ATM_card.setFont(new Font("raleway",Font.BOLD,14));
        ATM_card.setBounds(50,370,200,30);
        add(ATM_card);

        netbanking = new JCheckBox("Start Netbanking");
        netbanking.setFont(new Font("raleway",Font.BOLD,14));
        netbanking.setBounds(250,370,200,30);
        add(netbanking);

        mobilebanking = new JCheckBox("Start Mobilebanking");
        mobilebanking.setFont(new Font("raleway",Font.BOLD,14));
        mobilebanking.setBounds(50,420,200,30);
        add(mobilebanking);

        message_alert = new JCheckBox("Email and SMS Alerts");
        message_alert.setFont(new Font("raleway",Font.BOLD,14));
        message_alert.setBounds(250,420,200,30);
        add(message_alert);
        
        e_statements = new JCheckBox("ministatements");
        e_statements.setFont(new Font("raleway",Font.BOLD,14));
        e_statements.setBounds(50,470,200,30);
        add(e_statements);
        
        chequebook = new JCheckBox("Issue ChequeBook");
        chequebook.setFont(new Font("raleway",Font.BOLD,14));
        chequebook.setBounds(250,470,200,30);
        add(chequebook);

        passbook = new JCheckBox("Issue PassBook");
        passbook.setFont(new Font("raleway",Font.BOLD,14));
        passbook.setBounds(50,520,600,30);
        add(passbook);

        confirm = new JCheckBox("Ihere by declares that the above entered details are correct to the best of my knowledge.");
        confirm.setFont(new Font("raleway",Font.BOLD,12));
        confirm.setBounds(20,570,600,30);
        add(confirm);

        submit = new JButton("Submit");
        submit.setBounds(200,620,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500,620,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setTitle("Page3: Account Details");
        setSize(800,770);
        setLocation(250,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
          String accounttype = "none";
          if(saving.isSelected()){
            accounttype = "Saving Account";
          } else if(fixed.isSelected()){
            accounttype = "Fixed Deposit Account";
          } else if(current.isSelected()){
            accounttype = "Current Account";
          } else if(recurring.isSelected()){
            accounttype = "Recurring Deposit Account";
          }
          Random random = new Random();
          String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)) + 50409360L;
          String pinnumber = "" + Math.abs((random.nextLong() %9000L) + 1000L);
          
          String facility = null;
          if(ATM_card.isSelected()){
            facility = "ATM_card";
          } else if(netbanking.isSelected()){
            facility = facility + netbanking;
          } else if(mobilebanking.isSelected()){            
            facility = facility + mobilebanking;
          } else if(message_alert.isSelected()){
            facility = facility + message_alert;
          } else if(e_statements.isSelected()){
            facility = facility + e_statements;
          } else if(chequebook.isSelected()){
            facility = facility + chequebook;
          } else if(passbook.isSelected()){
            facility = facility + passbook;
          }

          try{
             if(accounttype.equals("none")){
                JOptionPane.showMessageDialog(null,"Account type is required !");
             } else {
                Conn conn = new Conn();
                String query4 = "insert into signup3 values('"+formno+"', '"+accounttype+"', '"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query5 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                conn.s.executeUpdate(query4);
                conn.s.executeUpdate(query5);
                JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber +"\n Pin Number: " + pinnumber);
                setVisible(false);
                new Login(formno).setVisible(true);
                
             }
          } catch(Exception e){
            System.out.println(e);
          }
        } else if(ae.getSource()==cancel){
             setVisible(false);
        }
    }
public static void main(String args[]){
   new Signup3("").setVisible(true);
}
    
}
