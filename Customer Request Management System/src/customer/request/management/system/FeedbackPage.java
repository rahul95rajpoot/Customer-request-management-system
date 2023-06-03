package customer.request.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class FeedbackPage extends JFrame implements ActionListener {
    
     JTextField namefield,idfield,titlefield;
     JTextArea feedbackTextArea;
     JButton submitButton,back;
     
    public FeedbackPage() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,100,1000,600);
        setTitle("Feedback Page");       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel titleLabel = new JLabel("Customer Feedback");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(400, 50, 350, 30);        
        add(titleLabel);

        // Create the components
        JLabel headingLabel = new JLabel("Please leave your feedback:");
        headingLabel.setBounds(200, 100, 200, 30);
        headingLabel.setFont(new Font("Serif", Font.BOLD, 16));
        add(headingLabel);
        
        JLabel namelbl = new JLabel("Name:");
        namelbl.setBounds(200, 150, 100, 30); 
        namelbl.setFont(new Font("Serif", Font.PLAIN, 14));
        add(namelbl);
         
        namefield = new JTextField();
        namefield.setBounds(300, 155, 100, 20);
        add(namefield);
        
        JLabel idlbl = new JLabel("Id:");
        idlbl.setBounds(200, 200, 200, 30);
        idlbl.setFont(new Font("Serif", Font.PLAIN, 14));
        add(idlbl);
        
        idfield = new JTextField();
        idfield.setBounds(300, 205, 200, 20);
        add(idfield);
        
        JLabel titlelbl = new JLabel("Title:");
        titlelbl.setBounds(200, 250, 200, 30); 
        titlelbl.setFont(new Font("Serif", Font.PLAIN, 14));
        add(titlelbl);
        
        titlefield = new JTextField();
        titlefield.setBounds(300, 255, 200, 20);
        add(titlefield);
        
        JLabel feedbackLabel = new JLabel("Feedback:");
        feedbackLabel.setBounds(200, 300, 100, 30);
        feedbackLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(feedbackLabel);
        
        feedbackTextArea = new JTextArea();
        feedbackTextArea.setBounds(300, 305, 350, 150);
        feedbackTextArea.setBackground(Color.YELLOW);
        add(feedbackTextArea);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(300, 480, 100, 20);
        submitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        submitButton.addActionListener(this);  
        add(submitButton);
        
        back = new JButton("Back");
        back.setBounds(450, 480, 100, 20);
        back.setFont(new Font("Serif", Font.PLAIN, 20));
        back.addActionListener(this);  
        add(back);
        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == submitButton) {
            String Name = namefield.getText();
            String Id = idfield.getText();
            String Title = titlefield.getText();
            String Feedback = feedbackTextArea.getText();
            
            
            if (Name.isEmpty() || Id.isEmpty() || Title.isEmpty() || Feedback.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
             }              
             try{
                Conn conn=new Conn();
                String query="insert into feedback values('"+Name+"','"+Id+"','"+Title+"','"+Feedback+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thank you for Your Feddback");
                
                setVisible(false);
                new CustomerPage();                
             }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }  else{
             setVisible(false);
             new CustomerPage();
         }    
    }

    public static void main(String[] args) {
        new FeedbackPage();
    }
}
