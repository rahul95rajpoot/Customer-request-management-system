package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JTextField tfuser,tfpass;
    JRadioButton adminRadioButton,customerRadioButton;
    JButton loginButton;
    
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel typeuser=new JLabel("User Type:");
        typeuser.setBounds(40,50,100,30);
        add(typeuser);
        
        adminRadioButton = new JRadioButton("Admin");
        adminRadioButton.setBackground(Color.WHITE);
        adminRadioButton.setBounds(150,50,100,30);
        add(adminRadioButton);
        
        customerRadioButton = new JRadioButton("Customer");
        customerRadioButton.setBackground(Color.WHITE);
        customerRadioButton.setBounds(250,50,150,30);
        add(customerRadioButton);
        
        ButtonGroup userTypeGroup = new ButtonGroup();
        userTypeGroup.add(adminRadioButton);
        userTypeGroup.add(customerRadioButton);
        
                       
        JLabel lbuser=new JLabel("Username");
        lbuser.setBounds(40,120,100,30);
        add(lbuser);
        
        tfuser=new JTextField();
        tfuser.setBounds(150,120,150,30);
        add(tfuser);
        
        JLabel lbpass=new JLabel("Password");
        lbpass.setBounds(40,170,100,30);
        add(lbpass);
        
        tfpass=new JTextField();
        tfpass.setBounds(150,170,150,30);
        add(tfpass);
        
        loginButton=new JButton("LOGIN");
        loginButton.setBounds(150,240,150,50);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i1=i.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(350,100,200,200);
        add(img);
        
        
        
        setSize(600,400);
        setLocation(450,200);
        setVisible(true);
        
        
    }
   public void actionPerformed(ActionEvent e) {

       
       
        if (e.getSource() == loginButton) {
            
           
            
            
            if (adminRadioButton.isSelected()) {            
                
                try{
                   String pass = tfpass.getText();
                   String user = tfuser.getText();
                   if (user.isEmpty() || pass.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
            }
                   Conn c=new Conn();
                   String query="select * from admin where user='"+user+"' and pass='"+pass+"'";
                   ResultSet rs =c.s.executeQuery(query);
                    if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Welcome Admin!");
                    
                    setVisible(false);
                    new AdminPage();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials!");
                }
                }catch(Exception ex){
                    ex.printStackTrace();
                }

            } else if (customerRadioButton.isSelected()) {

                try{ 
                   String password = tfpass.getText();
                   String username = tfuser.getText();
                   if (username.isEmpty() || password.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
            }                                     
                   Conn c=new Conn();
                   String query="select * from login where username='"+username+"' and password='"+password+"'";
                   ResultSet rs =c.s.executeQuery(query);
                   if(rs.next()){
                       JOptionPane.showMessageDialog(this, "Welcome Customer!");
                       setVisible(false);
                       new CustomerPage();
                   }else{                                    
                    JOptionPane.showMessageDialog(this, "Invalid credentials!");
                   }
                
                }catch(Exception ex){
                  ex.printStackTrace();
                }

            } else {                
                JOptionPane.showMessageDialog(this, "Please select a user type!");

            }
        }
    }

    public static void main(String args[])
    {
        new Login();
    }
}
