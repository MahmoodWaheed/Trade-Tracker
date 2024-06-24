//package gui;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//import javax.swing.*;
//import java.awt.*;
//
//public class PhoneForm extends JFrame {
//    public PhoneForm() {
//        setTitle("Manage Phones");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        setLayout(new BorderLayout());
//
//        JPanel formPanel = new JPanel(new GridLayout(3, 2));
//
//        formPanel.add(new JLabel("Phone Number:"));
//        JTextField phoneNumberField = new JTextField();
//        formPanel.add(phoneNumberField);
//
//        formPanel.add(new JLabel("Type:"));
//        JTextField typeField = new JTextField();
//        formPanel.add(typeField);
//
//        JPanel buttonPanel = new JPanel();
//
//        JButton saveButton = new JButton("Save");
//        JButton updateButton = new JButton("Update");
//        JButton deleteButton = new JButton("Delete");
//        JButton getButton = new JButton("Get");
//
//        buttonPanel.add(saveButton);
//        buttonPanel.add(updateButton);
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(getButton);
//
//        add(formPanel, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        saveButton.addActionListener(e -> {
//            // Implement save logic using PhoneDAO
//        });
//
//        updateButton.addActionListener(e -> {
//            // Implement update logic using PhoneDAO
//        });
//
//        deleteButton.addActionListener(e -> {
//            // Implement delete logic using PhoneDAO
//        });
//
//        getButton.addActionListener(e -> {
//            // Implement get logic using PhoneDAO
//        });
//
//        setVisible(true);
//    }
//}
//
package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */

import dao.PhoneDAO;
import entities.Phone;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PhoneForm extends JFrame {
    private JTextField phoneNumberField;
    private JTextField personIdField;
    private JTextField employeeIdField;
    private PhoneDAO phoneDAO;

    public PhoneForm() {
        phoneDAO = new PhoneDAO();

        setTitle("Manage Phones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));

        formPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        formPanel.add(phoneNumberField);

        formPanel.add(new JLabel("Person ID:"));
        personIdField = new JTextField();
        formPanel.add(personIdField);

        formPanel.add(new JLabel("Employee ID:"));
        employeeIdField = new JTextField();
        formPanel.add(employeeIdField);

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

        saveButton.addActionListener(e -> savePhone());
        updateButton.addActionListener(e -> updatePhone());
        deleteButton.addActionListener(e -> deletePhone());
        getButton.addActionListener(e -> getPhone());

        setVisible(true);
    }

    private void savePhone() {
        try {
            String phoneNumber = phoneNumberField.getText();
            Integer personId = personIdField.getText().isEmpty() ? null : Integer.parseInt(personIdField.getText());
            Integer employeeId = employeeIdField.getText().isEmpty() ? null : Integer.parseInt(employeeIdField.getText());

            Phone phone = new Phone();
            phone.setPhoneNumber(phoneNumber);
            phone.setPersonId(personId);
            phone.setEmployeeId(employeeId);

            phoneDAO.savePhone(phone);
            JOptionPane.showMessageDialog(this, "Phone saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving phone: " + e.getMessage());
        }
    }

    private void updatePhone() {
        try {
            String phoneNumber = phoneNumberField.getText();
            Integer personId = personIdField.getText().isEmpty() ? null : Integer.parseInt(personIdField.getText());
            Integer employeeId = employeeIdField.getText().isEmpty() ? null : Integer.parseInt(employeeIdField.getText());

            List<Phone> phones = phoneDAO.getPhonesByNumber(phoneNumber);
            if (phones.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Phone not found");
                return;
            }

            Phone phone = phones.get(0);
            phone.setPersonId(personId);
            phone.setEmployeeId(employeeId);

            phoneDAO.updatePhone(phone);
            JOptionPane.showMessageDialog(this, "Phone updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating phone: " + e.getMessage());
        }
    }

    private void deletePhone() {
        try {
            String phoneNumber = phoneNumberField.getText();

            List<Phone> phones = phoneDAO.getPhonesByNumber(phoneNumber);
            if (phones.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Phone not found");
                return;
            }

            Phone phone = phones.get(0);
            phoneDAO.deletePhone(phone.getId());
            JOptionPane.showMessageDialog(this, "Phone deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting phone: " + e.getMessage());
        }
    }

    private void getPhone() {
        try {
            String phoneNumber = phoneNumberField.getText();

            List<Phone> phones = phoneDAO.getPhonesByNumber(phoneNumber);
            if (phones.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Phone not found ");
                return;
            }

            Phone phone = phones.get(0);
            phoneNumberField.setText(phone.getPhoneNumber());
            personIdField.setText(phone.getPersonId() != null ? phone.getPersonId().toString() : "");
            employeeIdField.setText(phone.getEmployeeId() != null ? phone.getEmployeeId().toString() : "");

            JOptionPane.showMessageDialog(this, "Phone retrieved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving phone: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new PhoneForm();
    }
}

