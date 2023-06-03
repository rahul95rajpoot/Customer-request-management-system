package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestToHr extends JFrame implements ActionListener {
     
     JTextField employeeIdField, titlefield, departmentField,customernameField;
     JButton submitButton,back;

    public RequestToHr() {        
        setBounds(300,50, 1000,600);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize components
        JLabel titleLabel = new JLabel("Complaint to Hr");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(380, 50, 300, 30);
        add(titleLabel);

        JLabel customernameLabel = new JLabel("Customer Name:");
        customernameLabel.setBounds(200, 100, 200, 30);
        add(customernameLabel);

        customernameField = new JTextField();
        customernameField.setBounds(400, 100, 200, 30);
        add(customernameField);
        
        JLabel employeeIdLabel = new JLabel("Customer ID:");
        employeeIdLabel.setBounds(200, 150, 200, 30);
        add(employeeIdLabel);

        employeeIdField = new JTextField();
        employeeIdField.setBounds(400, 150, 200, 30);
        add(employeeIdField);

        JLabel titlelbl = new JLabel("Title:");
        titlelbl.setBounds(200, 200, 200, 30);
        add(titlelbl);

        titlefield = new JTextField();
        titlefield.setBounds(400, 200, 200, 30);
        add(titlefield);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(200, 250, 200, 30);
        add(departmentLabel);

        departmentField = new JTextField();
        departmentField.setBounds(400, 250, 200, 30);
        add(departmentField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 350, 100, 30);
        add(submitButton);
        
        back=new JButton("back");
        back.setBounds(520, 350, 100, 30);
        back.addActionListener(this);
        add(back);

        // Register action listener for submit button
        submitButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == submitButton) {
             
            String Id = employeeIdField.getText();
            String name = customernameField.getText();
            String title = titlefield.getText();
            String department = departmentField.getText();
            
            
            if (name.isEmpty() || Id.isEmpty() || title.isEmpty() || department.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
             }              
             try{
                Conn conn=new Conn();
                String query="insert into request values('"+name+"','"+Id+"','"+title+"','"+department+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Request Submitted successfully");
                
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
        new RequestToHr();
    }
}
