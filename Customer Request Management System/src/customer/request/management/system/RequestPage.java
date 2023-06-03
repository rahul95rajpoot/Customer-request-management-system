package customer.request.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestPage extends JFrame implements ActionListener {
     JLabel titleLabel, namelbl, descriptionLabel, titleLabel2,idlbl,departmentlbl;
     JComboBox<String> categoryComboBox;     
     JButton submitButton,back;
     JTextField titleField,idfield,namefield,dfield;
     JTextArea descriptionArea;

    public RequestPage() {
        super("Request Page");
        setLayout(null);
        setBounds(300,50, 1000,600);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        titleLabel = new JLabel("Request Page");
        titleLabel.setBounds(400, 10, 200, 50);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(titleLabel);      
        
        titleLabel2 = new JLabel("Title:");
        titleLabel2.setBounds(50, 120, 100, 20);
        add(titleLabel2);
        
        namelbl = new JLabel("Name:");
        namelbl.setBounds(50, 80, 100, 20);
        add(namelbl);
        
        namefield = new JTextField();
        namefield.setBounds(150, 80, 200, 20);
        add(namefield);
        
        departmentlbl = new JLabel("Department:");
        departmentlbl.setBounds(400, 80, 200, 20);
        add(departmentlbl);
        
        dfield = new JTextField();
        dfield.setBounds(500, 80, 200, 20);
        add(dfield);     
        
        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(50, 160, 100, 20);
        add(descriptionLabel);
        
        titleField = new JTextField();
        titleField.setBounds(150, 120, 200, 20);
        add(titleField);
        
        idlbl = new JLabel("Id:");
        idlbl.setBounds(400, 120, 50, 20);
        add(idlbl);
        
        idfield = new JTextField();
        idfield.setBounds(500, 120, 100, 20);
        add(idfield);        
        
        descriptionArea = new JTextArea();
        descriptionArea.setBackground(Color.YELLOW);
        descriptionArea.setBounds(150, 160, 400, 100);
        add(descriptionArea);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 450, 80, 30);
        submitButton.addActionListener(this);
        add(submitButton);
        
        back=new JButton("back");
        back.setBounds(500,450,80,30);
        back.addActionListener(this);
        add(back);
        
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            
            String Name = namefield.getText();
            String department = dfield.getText();
            String Title = titleField.getText();
            String Description = descriptionArea.getText();
            String Id = idfield.getText();
            
            
            if (Name.isEmpty() || department.isEmpty() || Title.isEmpty() || Description.isEmpty() || Id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
             }              
             try{
                Conn conn=new Conn();
                String query="insert into request values('"+Name+"','"+Id+"','"+Title+"','"+Description+"','"+department+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Your request submitted successfully");
                
                setVisible(false);
                new CustomerPage();                
             }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
          
        }else{
            setVisible(false);
            new CustomerPage();
        }
    }

    public static void main(String[] args) {
        new RequestPage();
    }
}
