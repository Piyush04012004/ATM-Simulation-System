package ASimulatorSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pin_change extends JFrame implements ActionListener{
    JLabel image,text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    Pin_change(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);

        text = new JLabel("Change your pinnumber:");
        text.setFont(new Font("raleway",Font.BOLD,15));
        text.setBounds(160,220,200,30);
        text.setForeground(Color.white);
        image.add(text);

        pintext = new JLabel("Enter your pinnumber:");
        pintext.setBounds(120,260,200,30);
        pintext.setForeground(Color.white);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setBounds(290,260,100,30);
        pin.setBackground(Color.white);
        add(pin);

        repintext = new JLabel("Re-enter your pinnumber:");
        repintext.setBounds(120,300,200,30);
        repintext.setForeground(Color.white);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setBounds(290,300,100,30);
        repin.setBackground(Color.white);
        add(repin);

        change =new JButton("Change");
        change.setBounds(140,350,100,30);
        change.addActionListener(this);
        add(change);

        back =new JButton("Back");
        back.setBounds(280,350,100,30);
        back.addActionListener(this);
        add(back);
        
        setSize(700,700 );
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        try{
            String npin =pin.getText();
            String rpin =repin.getText();

            if(!(npin.equals(rpin))){
               JOptionPane.showMessageDialog(null,"Entered pins doesn't match");
               return;
            } else if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your new pin.");
            } else if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter your pin.");
            } else{
                Conn conn = new Conn();
                String query9 = "update bank set pin = ('"+rpin+"') where pin = ('"+pinnumber+"')";
                String query10 = "update login set pin = ('"+rpin+"') where pin = ('"+pinnumber+"')";
                String query11 = "update signup3 set pin = ('"+rpin+"') where pin =('"+pinnumber+"')";

                conn.s.executeUpdate(query9);
                conn.s.executeUpdate(query10);
                conn.s.executeUpdate(query11);
                
                JOptionPane.showMessageDialog(null, "Pinchanged successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    } else{
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
 }
    public static void main(String args[]){
        new Pin_change("");
    }
}
