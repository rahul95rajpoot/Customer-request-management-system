
package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends JFrame implements ActionListener {
    JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    JTextField nameField, emailField;
    JPasswordField passwordField, confirmPasswordField;
    JButton signupButton,back;
    private String dob;

    public SignUpPage() {
        setLayout(null);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icon/signup.jfif"));
        Image i1=i.getImage().getScaledInstance(600, 430, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,600,430);
        add(img);

        Container container = getContentPane();
        container.setBackground(Color.CYAN);
        container.setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 50, 100, 30);
        img.add(nameLabel);
        

        nameField = new JTextField();
        nameField.setBounds(150, 50, 150, 30);
        img.add(nameField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 100, 100, 30);
        img.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 150, 30);
        img.add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 150, 100, 30);
        img.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 150, 30);
        img.add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(50, 200, 100, 30);
        img.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 200, 150, 30);
        img.add(confirmPasswordField);

        signupButton = new JButton("Sign Up");
        signupButton.setForeground(Color.WHITE);
        signupButton.setBounds(150, 300, 100, 30);
        signupButton.setBackground(Color.BLACK);
        signupButton.addActionListener(this);
        img.add(signupButton);
        
        back=new JButton("Back");
        back.setBounds(300,300,100,30 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);             
        back.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
});
        img.add(back);
        
        
       setSize(600,430);
       setLocation(250,100);      
      
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            
             if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields");
            return;
             }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                return ;
            }
             try{
                Conn conn=new Conn();
                String query="insert into login values('"+name+"','"+password+"','"+email+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                
                setVisible(false);
                new Login();                
             }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }      
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
