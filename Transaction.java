package ASimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,cancel;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        JLabel text = new JLabel("Please choose your transaction:");
        text.setFont(new Font("raleway",Font.BOLD,16));
        text.setBounds(140,220,300,30);
        text.setForeground(Color.white);
        image.add(text);
         
        deposit = new JButton("Deposit");
        deposit.setBounds(130,260,110,30);
        deposit.setBackground(Color.white);
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(260,260,125,30);
        withdrawl.setBackground(Color.white);
        withdrawl.addActionListener(this);
        add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130,310,110,30);
        fastcash.setBackground(Color.white);
        fastcash.addActionListener(this);
        add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(260,310,120,30);
        ministatement.setBackground(Color.white);
        ministatement.addActionListener(this);
        add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(130,360,120,30);
        pinchange.setBackground(Color.white);
        pinchange.addActionListener(this);
        add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(260,360,140,30);
        balanceenquiry.setBackground(Color.white);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);

        cancel = new JButton("Cancel");
        cancel.setBounds(260,400,100,30);
        cancel.setBackground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        setSize(700,700 );
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == cancel){
        System.exit(0);
    } else if(ae.getSource() == deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);    
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
         new Cash_withdrawl(pinnumber).setVisible(true);
    } else if(ae.getSource() == fastcash){
        setVisible(false);
        new Fastcash(pinnumber).setVisible(true);

    } else if(ae.getSource() == ministatement){
        setVisible(false);
        new Ministatements(pinnumber).setVisible(true);
    } else if(ae.getSource() == pinchange){
        setVisible(false);
        new Pin_change(pinnumber).setVisible(true);
    } else if(ae.getSource() == balanceenquiry){
        setVisible(false);
        new Balance_enquiry(pinnumber).setVisible(true);
    }
    }
    public static void main(String args[]){
        new Transaction("");
    }
}
