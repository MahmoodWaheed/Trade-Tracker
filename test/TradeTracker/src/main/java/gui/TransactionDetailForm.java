package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.*;

public class TransactionDetailForm extends JFrame {
    public TransactionDetailForm() {
        setTitle("Manage Transaction Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Transaction ID:"));
        JTextField transactionIdField = new JTextField();
        formPanel.add(transactionIdField);

        formPanel.add(new JLabel("Item ID:"));
        JTextField itemIdField = new JTextField();
        formPanel.add(itemIdField);

        formPanel.add(new JLabel("Quantity:"));
        JTextField quantityField = new JTextField();
        formPanel.add(quantityField);

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
            // Implement save logic using TransactionDetailDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using TransactionDetailDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using TransactionDetailDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using TransactionDetailDAO
        });

        setVisible(true);
    }
}

