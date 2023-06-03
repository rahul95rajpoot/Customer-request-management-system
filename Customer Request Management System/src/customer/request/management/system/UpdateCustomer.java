package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    JTextField tfage,tffname,tfmail,tfaddress,tfphone,searchField;
    JLabel lblcustId;    
    JButton add,back,searchButton;
    String custId;
    
    UpdateCustomer(String custId)
    {
        this.custId=custId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Customer Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading); 
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(50,150,150,30);
        lbname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel lbfname=new JLabel("Father Name");
        lbfname.setBounds(400,150,200,30);
        lbfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lbfname);
        
        tffname=new JTextField();
        tffname.setBounds(550,150,150,30);
        add(tffname);
        
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(50,200,200,30);
        lbdob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbdob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel lbage=new JLabel("Age");
        lbage.setBounds(400,200,200,30);
        lbage.setFont(new Font("serif",Font.PLAIN,20));
        add(lbage);
        
        tfage=new JTextField();
        tfage.setBounds(550,200,150,30);
        add(tfage);
        
        JLabel lbmail=new JLabel("E-Mail");
        lbmail.setBounds(50,250,200,30);
        lbmail.setFont(new Font("serif",Font.PLAIN,20));
        add(lbmail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200,250,150,30);
        add( tfmail);
        
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(400,250,200,30);
        lbphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(550,250,150,30);
        add(tfphone);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(50,300,200,30);
        lbaddress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,300,150,30);
        add(tfaddress);
        
        JLabel cusId=new JLabel("Customer Id");
        cusId.setBounds(400,300,200,30);
        cusId.setFont(new Font("serif",Font.PLAIN,20));
        add(cusId);
        
        lblcustId=new JLabel();
        lblcustId.setBounds(550,300,200,30);
        lblcustId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblcustId);
        
        try{
            Conn c=new Conn();
            String query="select * from customer where Customer_Id='"+custId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("Father_name"));              
                lbldob.setText(rs.getString("Dob"));
                tfage.setText(rs.getString("Age"));
                tfmail.setText(rs.getString("mail"));
                tfphone.setText(rs.getString("Phone"));
                tfaddress.setText(rs.getString("Address"));
                lblcustId.setText(rs.getString("Customer_Id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add=new JButton("Update Details");
        add.setBounds(250,450,150,40 );

        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);        
               
        back=new JButton("Back");
        back.setBounds(450,450,150,40 );

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new AdminPage();
    }
});
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add){
            String fname = tffname.getText();
            String Age= tfage.getText();
            String mail= tfmail.getText();
            String phone= tfphone.getText();
            String address= tfaddress.getText();
                       
                       
         try{
                Conn c=new Conn();
                String query="update customer set Father_name='"+fname+"',Age='"+Age+"', mail='"+mail+"', Phone='"+phone+"', Address='"+address+"' where Customer_Id='"+custId+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new AdminPage();

            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
           setVisible (false);
           new AdminPage();
        }
       
    }
    
    public static void main(String aegs[])
    {
        new UpdateCustomer("");
    }
    
}

