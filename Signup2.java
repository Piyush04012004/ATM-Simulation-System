package ASimulatorSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
        
    long random;
        JComboBox religion,category,income,education,occupation;
        JTextField pannumber,adharnumber;
        ButtonGroup snGroup,enGroup;
        JButton next;
        JRadioButton syes,sno,eyes,eno;
        String formno;

        Signup2(String formno){
        this.formno = formno; 
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        
        JLabel additionaldetails = new JLabel("PAGE-2  ADDITIONAL DETAILS ");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(200,50,400,30);
        add(additionaldetails);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Arial",Font.BOLD,16));
        Religion.setBounds(80,110,100,30);
        add(Religion);

        String valReligion[] = {"None","Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Arial",Font.BOLD,14));
        religion.setBounds(250,110,300,30);
        religion.setBackground(Color.white);
        add(religion);
    
        JLabel Category = new JLabel("Category: ");
        Category.setFont(new Font("Arial",Font.BOLD,16));
        Category.setBounds(80,170,150,30);
        add(Category);

        String valCategory[] = {"None","General","SC","ST","OBC","Other"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Arial",Font.BOLD,14));
        category.setBounds(250,170,300,30);
        category.setBackground(Color.white);
        add(category);
    
        JLabel Income = new JLabel("Income: ");
        Income.setFont(new Font("Arial",Font.BOLD,16));
        Income.setBounds(80,230,150,30);
        add(Income);

        String valIncome[] = {"None","< 1,50,000","< 2,50,000","< 5,00,000","Above 5,00,000"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Arial",Font.BOLD,14));
        income.setBounds(250,230,300,30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel Education = new JLabel("Educational  ");
        Education.setFont(new Font("Arial",Font.BOLD,16));
        Education.setBounds(80,290,200,30);
        add(Education); 

        JLabel Qualification = new JLabel("Qualification :");
        Qualification.setFont(new Font("Arial",Font.BOLD,16));
        Qualification.setBounds(80,310,200,30);
        add(Qualification);
       
        String valEducation[] = {"None","Non-Graduate","Under-Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(valEducation);
        education.setFont(new Font("Arial",Font.BOLD,14));
        education.setBounds(250,300,300,30);
        education.setBackground(Color.white);
        add(education);

        JLabel Occupation = new JLabel("Occupational : ");
        Occupation.setFont(new Font("Arial",Font.BOLD,16));
        Occupation.setBounds(80,410,150,30);
        add(Occupation);

        String valOccupation[] = {"None","Salaried Employee","SelfEmployeed","Businessman","Student","Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setFont(new Font("Arial",Font.BOLD,14));
        occupation.setBounds(250,410,300,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel PanNumber = new JLabel("PAN number:");
        PanNumber.setFont(new Font("Arial",Font.BOLD,16));
        PanNumber.setBounds(80, 450,300, 30);
        add(PanNumber);

        pannumber = new JTextField();
        pannumber.setFont(new Font("Arial",Font.BOLD,14));
        pannumber.setBounds(250,450,300,30);
        pannumber.setBackground(Color.white);
        add(pannumber);
        
        JLabel AdharNumber = new JLabel("Aadhar number: ");
        AdharNumber.setFont(new Font("Arial",Font.BOLD,16));
        AdharNumber.setBounds(80,490,300,30);
        add(AdharNumber);
        
        adharnumber = new JTextField();
        adharnumber.setFont(new Font("Arial",Font.BOLD,14));
        adharnumber.setBounds(250,490,300,30);
        religion.setBackground(Color.white);
        add(adharnumber);
    
        JLabel SeniorCitizen = new JLabel("Senior Citizen : ");
        SeniorCitizen.setFont(new Font("Arial",Font.BOLD,16));
        SeniorCitizen.setBounds(80,530,100,30);
        add(SeniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Arial",Font.BOLD,14));
        syes.setBounds(250,530,100,30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setFont(new Font("Arial",Font.BOLD,14));
        sno.setBounds(350,530,100,30);
        add(sno);

        snGroup = new ButtonGroup();
        snGroup.add(syes);
        snGroup.add(sno);

        JLabel ExistingAccount = new JLabel("Existing Account : ");
        ExistingAccount.setFont(new Font("Arial",Font.BOLD,15));
        ExistingAccount.setBounds(80,590,200,30);
        add(ExistingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Arial",Font.BOLD,14));
        eyes.setBounds(250,590,100,30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setFont(new Font("Arial",Font.BOLD,14));
        eno.setBounds(350,590,100,30);
        add(eno);

        enGroup = new ButtonGroup();
        enGroup.add(eyes);
        enGroup.add(eno);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(750,750);
        setLocation(300, 20);
        setVisible(true);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550,650,100,30);
        next.addActionListener(this);
    add(next);
    } 
    public void actionPerformed(ActionEvent ae){
       String formno = "" + random;
       String sreligion = (String)religion.getSelectedItem();
       String scategory = (String)category.getSelectedItem();
       String sincome = (String)income.getSelectedItem();
       String seducation = (String)education.getSelectedItem();
       String soccupation = (String)occupation.getSelectedItem();
       String spannumber = pannumber.getText();
       String sadharnumber = adharnumber.getText();
       String seniorcitizen = null;
       if(syes.isSelected()){
        seniorcitizen = "yes";
       } else if(sno.isSelected()){
         seniorcitizen = "no";
       }
       String existingaccount =null;
       if(eyes.isSelected()){
        existingaccount = "yes";
       } else if(eno.isSelected()){
        existingaccount = "no";
       }

     try{
       Conn c = new Conn();
        String query3 = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spannumber+"','"+sadharnumber+"','"+seniorcitizen+"','"+existingaccount+"')";
        c.s.executeUpdate(query3);
        setVisible(false);
        new Signup3(formno).setVisible(true);
        
      } catch(Exception e){
      System.out.println(e);
     }
    }
    public static void main(String args[]){
        new Signup2("").setVisible(true);
    }
}
