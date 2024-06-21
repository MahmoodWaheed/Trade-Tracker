package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.*;

public class TransactionForm extends JFrame {
    public TransactionForm() {
        setTitle("Manage Transactions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Transaction Date:"));
        JTextField transactionDateField = new JTextField();
        formPanel.add(transactionDateField);

        formPanel.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        formPanel.add(amountField);

        JPanel buttonPanel = new JPanel();

        JButton saveButton = new JButton("Save");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton getButton = new JButton("Get");

        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(getButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            // Implement save logic using TransactionDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using TransactionDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using TransactionDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using TransactionDAO
        });

        setVisible(true);
    }
}

