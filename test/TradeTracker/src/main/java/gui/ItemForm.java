package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.*;

public class ItemForm extends JFrame {
    public ItemForm() {
        setTitle("Manage Items");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Item Name:"));
        JTextField itemNameField = new JTextField();
        formPanel.add(itemNameField);

        formPanel.add(new JLabel("Price:"));
        JTextField priceField = new JTextField();
        formPanel.add(priceField);

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
            // Implement save logic using ItemDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using ItemDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using ItemDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using ItemDAO
        });

        setVisible(true);
    }
}

