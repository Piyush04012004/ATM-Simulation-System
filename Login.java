package ASimulatorSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//LoginClass 
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardnoField;
    JPasswordField pinnoField;
    String formno;
    Login(String formno){
      this.formno = formno;
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);     
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
      //CardNumber
        JLabel cardno = new JLabel("Card number:");
        cardno.setFont(new Font("Raleway", Font.BOLD,28));
        cardno.setBounds(120,150,400,40);
        add(cardno);
        
        cardnoField = new JTextField();
        cardnoField.setBounds(320,150,250,40);
        cardnoField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardnoField);

       
      //Pin Number
        JLabel pinno = new JLabel("Pin number:");
        pinno.setFont(new Font("Raleway", Font.BOLD,28));
        pinno.setBounds(120,220,400,40);
        add(pinno);

        pinnoField = new JPasswordField();
        pinnoField.setBounds(320,220,250,40);
        pinnoField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinnoField);
        
        login = new JButton("Sign in");
        login.setBounds(320,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(320,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        //Login Frame
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setLocation(280,100);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == clear){
      cardnoField.setText("");
      pinnoField.setText("");
     } else if(ae.getSource() == login){
      Conn conn = new Conn();
      String cardnumber = cardnoField.getText();
      String pinnumber = pinnoField.getText();
      String query1 = "select * from login where cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"'";
     try{
          ResultSet rs = conn.s.executeQuery(query1);
          if(rs.next()){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
          } else{
            JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin number");
          }
      } catch(Exception e){
        System.out.println(e);
      }
     } else if(ae.getSource() == signup){
      setVisible(false);
      new Signup(formno).setVisible(true);
     }
       
  }
    //main Class
    public static void main(String args[]){
        new Login("").setVisible(true);
    }
}
