package ASimulatorSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;


public class Signup extends JFrame implements ActionListener{
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String random = " " + Math.abs(first4);
    JLabel Formno;
    JTextField namefield,fathernamefield,emailfield,addressfield,cityfield,statefield,pincodefield;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser datechooser;
  
    Signup(String random){
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);     
    JLabel label= new JLabel(i3);
    label.setBounds(35,0,100,100);
    add(label);
    
    
    Formno = new JLabel("Application Form number: " + random);
    Formno.setFont(new Font("Arial",Font.BOLD,30));
    Formno.setBounds(160,18,700,30);
    add(Formno);

    JLabel persondetails = new JLabel("Page 1: Personal Details");
    persondetails.setFont(new Font("Arial",Font.BOLD,18));
    persondetails.setBounds(260,60,600,30);
    add(persondetails);

    JLabel name = new JLabel("Name : ");
    name.setFont(new Font("Arial",Font.BOLD,15));
    name.setBounds(80,110,100,30);
    add(name);

    namefield = new JTextField();
    namefield.setFont(new Font("Arial",Font.BOLD,14));
    namefield.setBounds(250,110,350,30);
    add(namefield);

    JLabel fathername = new JLabel("Father's Name : ");
    fathername.setFont(new Font("Arial",Font.BOLD,15));
    fathername.setBounds(80,170,150,30);
    add(fathername);

    fathernamefield = new JTextField();
    fathernamefield.setFont(new Font("Arial",Font.BOLD,14));
    fathernamefield.setBounds(250,170,350,30);
    add(fathernamefield);


    JLabel DOB = new JLabel("Date Of  Birth : ");
    DOB.setFont(new Font("Arial",Font.BOLD,15));
    DOB.setBounds(80,230,150,30);
    add(DOB);

    datechooser = new JDateChooser();
    datechooser.setBounds(250,230,350,30);
    add(datechooser);

    JLabel email = new JLabel("Email Address :  ");
    email.setFont(new Font("Arial",Font.BOLD,15));
    email.setBounds(80,290,200,30);
    add(email);

    emailfield = new JTextField();
    emailfield.setFont(new Font("Arial",Font.BOLD,14));
    emailfield.setBounds(250,290,350,30);
    add(emailfield);

    JLabel gender = new JLabel("Gender : "  );
    gender.setFont(new Font("Arial",Font.BOLD,15));
    gender.setBounds(80,350,100,30);
    add(gender);

    male = new JRadioButton("Male");
    male.setBounds(250,350,60,30);
    add(male);
    female = new JRadioButton("Female");
    female.setBounds(350,350,90,30);
    add(female);

    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male); 
    gendergroup.add(female);
    JLabel marital = new JLabel("Marital Status : ");
    marital.setFont(new Font("Arial",Font.BOLD,15));
    marital.setBounds(80,410,150,30);
    add(marital);

    married =  new JRadioButton("Married");
    married.setBounds(250,410,90,30);
    add(married);

    unmarried =  new JRadioButton("Unmarried");
    unmarried.setBounds(350,410,90,30);
    add(unmarried);

    other =  new JRadioButton("Other");
    other.setBounds(450,410,90,30);
    add(other);

    ButtonGroup maritalgroup = new ButtonGroup();
    maritalgroup.add(married);
    maritalgroup.add(unmarried);
    maritalgroup.add(other);
    
    JLabel address = new JLabel("Address");
    address.setFont(new Font("Arial",Font.BOLD,15));
    address.setBounds(80, 450,300, 30);
    add(address);

    addressfield = new JTextField();
    addressfield.setFont(new Font("Arial",Font.BOLD,14));
    addressfield.setBounds(250,450,350,30);
    add(addressfield);
    JLabel city = new JLabel("City : ");
    city.setFont(new Font("Arial",Font.BOLD,15));
    city.setBounds(80,490,100,30);
    add(city);
    cityfield = new JTextField();
    cityfield.setFont(new Font("Arial",Font.BOLD,14));
    cityfield.setBounds(250,490,350,30);
    add(cityfield);
    
    JLabel state = new JLabel("State : ");
    state.setFont(new Font("Arial",Font.BOLD,15));
    state.setBounds(80,530,100,30);
    add(state);

    statefield = new JTextField();
    statefield.setFont(new Font("Arial",Font.BOLD,14));
    statefield.setBounds(250,530,350,30);
    add(statefield);

    JLabel pincode = new JLabel("Pin Code : ");
    pincode.setFont(new Font("Arial",Font.BOLD,15));
    pincode.setBounds(80,590,100,30);
    add(pincode);
     
    pincodefield = new JTextField();
    pincodefield.setFont(new Font("Arial",Font.BOLD,14));
    pincodefield.setBounds(250,590,350,30);
    add(pincodefield);

    
    JButton next = new JButton("Next");
    next.setBackground(Color.black);
    next.setForeground(Color.white);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(550,650,100,30);
    next.addActionListener(this);
    add(next);

   //  getContentPane().setBackground(Color.WHITE);
    setSize(750,750);
    setLocation(300, 20);
    setVisible(true);
  }
  public void actionPerformed(ActionEvent ae){
   
     String formno = ""+random;
     String name = namefield.getText();
     String fathername = fathernamefield.getText();
     String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
     String gender = null;
     if(male.isSelected()){
        gender = "Male";
     }else if(female.isSelected()){
        gender = "female";
     }
     String email = emailfield.getText();
     String marital = null;
     if(married.isSelected()){
      marital = "Married";
     } else if(unmarried.isSelected()){
      marital = "Unmarried";
     } else if(other.isSelected()){
      marital = "Other";
     }

     String address = addressfield.getText();
     String city = cityfield.getText();
     String state = statefield.getText();
     String pincode = pincodefield.getText();

    try{
      if(name.equals("")){
         JOptionPane.showMessageDialog(null,"Name is required !");
      }
      else if(fathername.equals("")){
         JOptionPane.showMessageDialog(null,"Father name is required !");
      } else if(dob.equals("")){
         JOptionPane.showMessageDialog(null,"Date of Birth is required !");
      } else if(email.equals("")){
         JOptionPane.showMessageDialog(null,"Email is required !");
      }  else if(gender.equals("")){
         JOptionPane.showMessageDialog(null,"Gender is required !");
      }  else if(address.equals("")){
         JOptionPane.showMessageDialog(null,"Address is required !");
      }  else if(city.equals("")){
         JOptionPane.showMessageDialog(null,"City is required !");
      }  else if(state.equals("")){
         JOptionPane.showMessageDialog(null,"State is required !");
      }  else{
        Conn c = new Conn();
        String query2 = "insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
        c.s.executeUpdate(query2);
        setVisible(false);
        new Signup2(formno).setVisible(true);
        
   }

}
       catch(Exception e){
      System.out.println(e);
     }
    }
   public static void main(String args[]){
        new Signup("").setVisible(true);;
    }
}
