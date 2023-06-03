package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplaintToCeo extends JFrame implements ActionListener {

     
     JTextField nameField, titleField, idfield,dfield;
     JTextArea reasonArea;
     JButton submitButton, cancelButton,back;

    public ComplaintToCeo() {
        super("Complaint");
        setBounds(300,50, 1000,600);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        JLabel titleLabel = new JLabel("Complaint");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(400, 50, 300, 30);
        add(titleLabel);
        
        JLabel departmentlbl = new JLabel("Department:");
        departmentlbl.setBounds(300, 100, 200, 30);
        add(departmentlbl);
        
        dfield = new JTextField();
        dfield.setBounds(450, 100, 250, 30);
        add(dfield); 

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(300, 150, 100, 30);
        
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(450, 150, 250, 30);
        add(nameField);

        JLabel id = new JLabel("Id:");
        id.setBounds(300, 200, 100, 30);
        add(id);  
        
        idfield = new JTextField();
        idfield.setBounds(450, 200, 250, 30);
        add(idfield);

        JLabel title = new JLabel("Title:");
        title.setBounds(300, 250, 100, 30);
        add(title);  
        
        titleField = new JTextField();
        titleField.setBounds(450, 250, 250, 30);
        add(titleField);

        JLabel reasonLabel = new JLabel("Reason:");
        reasonLabel.setBounds(300, 300, 100, 30);
        add(reasonLabel);

        reasonArea = new JTextArea();
        reasonArea.setBackground(Color.YELLOW);
        reasonArea.setBounds(450, 300, 250, 100);
        add(reasonArea);

        submitButton = new JButton("Submit");
        submitButton.setBounds(300, 450, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);        
        
        back = new JButton("Back");
        back.setBounds(600, 450, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            
            String name = nameField.getText();
            String department = dfield.getText();
            String id = idfield.getText();
            String title = titleField.getText();
            String reason = reasonArea.getText();

            
            if (name.isEmpty() || id.isEmpty() || department.isEmpty() || title.isEmpty() || reason.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            }
             try{
                Conn conn=new Conn();
                String query="insert into request values('"+name+"','"+id+"','"+title+"','"+reason+"','"+department+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Request submitted successfully.");
                
                setVisible(false);
                new CustomerPage();                
             }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
           
        }      
        else{
            setVisible(false);
            new CustomerPage();
        }
    }

    public static void main(String[] args) {
        new ComplaintToCeo();
    }
}
