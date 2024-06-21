package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */

import javax.swing.*;
import java.awt.*;

public class PaymentForm extends JFrame {
    public PaymentForm() {
        setTitle("Manage Payments");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Payment Date:"));
        JTextField paymentDateField = new JTextField();
        formPanel.add(paymentDateField);

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
            // Implement save logic using PaymentDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using PaymentDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using PaymentDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using PaymentDAO
        });

        setVisible(true);
    }
}

