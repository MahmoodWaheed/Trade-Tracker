package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.*;

public class PhoneForm extends JFrame {
    public PhoneForm() {
        setTitle("Manage Phones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        formPanel.add(phoneNumberField);

        formPanel.add(new JLabel("Type:"));
        JTextField typeField = new JTextField();
        formPanel.add(typeField);

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
            // Implement save logic using PhoneDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using PhoneDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using PhoneDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using PhoneDAO
        });

        setVisible(true);
    }
}

