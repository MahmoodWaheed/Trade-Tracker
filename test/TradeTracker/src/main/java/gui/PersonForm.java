package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.*;

public class PersonForm extends JFrame {
    public PersonForm() {
        setTitle("Manage Persons");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        formPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        formPanel.add(locationField);

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
            // Implement save logic using PersonDAO
        });

        updateButton.addActionListener(e -> {
            // Implement update logic using PersonDAO
        });

        deleteButton.addActionListener(e -> {
            // Implement delete logic using PersonDAO
        });

        getButton.addActionListener(e -> {
            // Implement get logic using PersonDAO
        });

        setVisible(true);
    }
}

