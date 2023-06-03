
package customer.request.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener{
    
    JButton clickhere,click;
    
    Splash()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel l=new JLabel("CUSTOMER REQUEST MANAGEMENT SYSTEM");
        l.setBounds(60,10,1200,60);
        l.setFont(new Font("serif",Font.PLAIN,40));
        l.setForeground(Color.RED);        
        add(l);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
        Image i1=i.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(50,80,900,500);
        add(img);
        
        clickhere=new JButton("click here to Login");
        clickhere.setBounds(100,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        img.add(clickhere);
        
        click=new JButton("click here to Signup");
        click.setBounds(500,400,300,70);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        img.add(click);
        
        setSize(1000,650);
        setLocation(100,50);
        setVisible(true);
        
        while(true)
        {
            l.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
            l.setVisible(true);
              try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()== clickhere)
       {
           setVisible(false);
           new Login();
       }
       else
       {
           setVisible(false);
           new SignUpPage();
       }
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
