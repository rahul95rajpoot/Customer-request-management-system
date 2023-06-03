package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewCustomer extends JFrame implements ActionListener {

    JTable table;
    Choice ccustomerId;
    JButton search, print, back, update;

    ViewCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("search by Customer id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        ccustomerId = new Choice();
        ccustomerId.setBounds(180, 20, 150, 20);
        add(ccustomerId);

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from  customer");

            while (rs.next()) {
                ccustomerId.add(rs.getString("Customer_Id"));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("print");
        print.setBounds(110, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("update");
        update.setBounds(200, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("back");
        back.setBounds(290, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setBounds(300, 100, 900, 700);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from customer where Customer_Id='" + ccustomerId.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCustomer(ccustomerId.getSelectedItem());
        } else {
            setVisible(false);
            new AdminPage();
        }
    }

    public static void main(String args[]) {
        new ViewCustomer();
    }
}

