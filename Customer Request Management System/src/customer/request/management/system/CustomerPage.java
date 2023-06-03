package customer.request.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CustomerPage extends JFrame implements ActionListener{
    JButton req,reqhr,reqleave,viewfeedback,logout;
    
    CustomerPage()
    {
       setLayout(null);
       
       ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image i1=i.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,1000,500);
        add(img);
        
        JLabel heading=new JLabel("CUSTOMER REQUEST MANAGEMENT SYSTEM");
        heading.setForeground(Color.WHITE);
        heading.setBounds(230,20,600,40);
        heading.setFont(new Font("serif",Font.PLAIN,25));
        img.add(heading);
        
        req=new JButton("Customer Request");
        req.setBounds(650,80,150,40 );
        req.addActionListener(this);
        img.add(req);
                      
        reqhr=new JButton("Complaint to Hr");
        reqhr.setBounds(820,80,150,40 );
        reqhr.addActionListener(this);
        img.add(reqhr);
        
        reqleave=new JButton("Request to Ceo");
        reqleave.setBounds(650,140,150,40 );
        reqleave.addActionListener(this);
        img.add(reqleave);
        
        viewfeedback=new JButton("feedback");
        viewfeedback.setBounds(820,140,150,40 );
        viewfeedback.addActionListener(this);
        img.add(viewfeedback);
        
        logout=new JButton("Logout");
        logout.setBounds(880,410,100,20 );
        logout.addActionListener(this);
        img.add(logout);
       
        
       setSize(1000,500);
       setLocation(250,100);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == req)
       {
           setVisible(false);
           new RequestPage();
       }
       else if(ae.getSource()== reqhr)
       {
           setVisible(false);
           new RequestToHr();
       }
       else if(ae.getSource()==viewfeedback)
       {
          setVisible(false);
          new FeedbackPage();
          
       }
       else if(ae.getSource()==logout)
       {
          setVisible(false);
          new Login();
          
       }
           else {
                   setVisible(false);
                   new ComplaintToCeo();
                }
       }
    
    public static void main(String agrs[])
    {
        new CustomerPage();
    }
}

