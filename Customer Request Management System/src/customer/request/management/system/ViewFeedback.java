package customer.request.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class ViewFeedback extends JFrame implements ActionListener {

    JLabel titleLabel;    
    JTable requestTable, table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JButton back;

    public ViewFeedback() {
        super("Feedback Page");
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 100, 1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("Customer feedback");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(400, 50, 300, 30);
        add(titleLabel);        

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  feedback");           

        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from feedback");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(100, 100, 750, 350);
        add(jsp);

        back = new JButton("back");
        back.setBounds(450, 500, 100, 30);
        back.addActionListener(this);
        add(back);
        

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new AdminPage();
        }
    }

    public static void main(String[] args) {
        new ViewFeedback();
    }
}
