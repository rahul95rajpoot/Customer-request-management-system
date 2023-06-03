package customer.request.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HrPage extends JFrame implements ActionListener {
    private JTable requestTable;
    private JScrollPane scrollPane;
    private JButton approveButton, rejectButton;
    private JLabel statusLabel;

    public HrPage() {
        super("HR Page");
        setBounds(300, 50, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize components
        JLabel titleLabel = new JLabel("Salary Increase Requests");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(380, 50, 300, 30);
        add(titleLabel);

        // Create the table and scroll pane
        String[] columnNames = {"Employee ID", "Current Salary", "Requested Salary", "Status"};
        Object[][] data = {
                {"1001", 50000.0, 60000.0, "Pending"},
                {"1002", 75000.0, 80000.0, "Pending"},
                {"1003", 90000.0, 100000.0, "Approved"}
        };
        requestTable = new JTable(data, columnNames);
        requestTable.setBounds(100, 150, 800, 300);
        requestTable.setDefaultEditor(Object.class, null);
        scrollPane = new JScrollPane(requestTable);
        scrollPane.setBounds(100, 150, 800, 300);
        add(scrollPane);

        // Create the approve and reject buttons
        approveButton = new JButton("Approve");
        approveButton.setBounds(400, 475, 100, 30);
        approveButton.addActionListener(this);
        add(approveButton);

        rejectButton = new JButton("Reject");
        rejectButton.setBounds(520, 475, 100, 30);
        rejectButton.addActionListener(this);
        add(rejectButton);

        // Create the status label
        statusLabel = new JLabel(" ");
        statusLabel.setBounds(400, 520, 200, 30);
        add(statusLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == approveButton) {
            // Handle approve button click
            int selectedRow = requestTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Update the status to Approved
                requestTable.setValueAt("Approved", selectedRow, 3);
                statusLabel.setText("Request Approved.");
            } else {
                statusLabel.setText("Please select a request to approve.");
            }
        } else if (e.getSource() == rejectButton) {
            // Handle reject button click
            int selectedRow = requestTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Update the status to Rejected
                requestTable.setValueAt("Rejected", selectedRow, 3);
                statusLabel.setText("Request Rejected.");
            } else {
                statusLabel.setText("Please select a request to reject.");
            }
        }
    }

    public static void main(String[] args) {
        new HrPage();
    }
}
