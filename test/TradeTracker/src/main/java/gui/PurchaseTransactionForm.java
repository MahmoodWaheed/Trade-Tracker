package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */


import javax.swing.*;
import java.awt.*;

public class PurchaseTransactionForm extends JFrame {
    public PurchaseTransactionForm() {
        setTitle("Manage Purchase Transactions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Purchase Date:"));
        JTextField purchaseDateField = new JTextField();
        formPanel.add(purchaseDateField);

        formPanel.add(new JLabel("Supplier ID:"));
        JTextField supplierIdField = new JTextField();
        formPanel.add(supplierIdField);

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
            // Implement save logic using PurchaseTransactionDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using PurchaseTransactionDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using PurchaseTransactionDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using PurchaseTransactionDAO
        });

        setVisible(true);
    }
}

