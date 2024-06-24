//package gui;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/24/2024
// * PROJECT NAME: TradeTracker
// */
//
//
//import dao.TransactionDAO;
//import dao.TransactionDetailDAO;
//import entities.Transaction;
//import entities.TransactionDetail;
//import entities.Employee;
//import entities.Item;
//import entities.Person;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import com.toedter.calendar.JDateChooser;
//import java.awt.*;
//import java.util.Date;
//import java.util.List;
//
//public class SalesForm extends JFrame {
//    private JDateChooser transactionDateChooser;
//    private JTextField totalAmountField;
//    private JTextField salesRepresentativeIdField;
//    private JTextField personIdField;
//    private JTable transactionDetailsTable;
//    private DefaultTableModel tableModel;
//    private TransactionDAO transactionDAO;
//    private TransactionDetailDAO transactionDetailDAO;
//
//    public SalesForm() {
//        transactionDAO = new TransactionDAO();
//        transactionDetailDAO = new TransactionDetailDAO();
//
//        setTitle("Record Sales Transaction");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        setLayout(new BorderLayout());
//
//        JPanel formPanel = new JPanel(new GridLayout(5, 2));
//
//        // Auto-generated transaction ID
//        formPanel.add(new JLabel("Transaction ID:"));
//        JLabel transactionIdLabel = new JLabel("Auto-generated");
//        formPanel.add(transactionIdLabel);
//
//        formPanel.add(new JLabel("Transaction Date:"));
//        transactionDateChooser = new JDateChooser(new Date());
//        formPanel.add(transactionDateChooser);
//
//        formPanel.add(new JLabel("Total Amount:"));
//        totalAmountField = new JTextField();
//        formPanel.add(totalAmountField);
//
//        formPanel.add(new JLabel("Sales Representative ID:"));
//        salesRepresentativeIdField = new JTextField();
//        formPanel.add(salesRepresentativeIdField);
//
//        formPanel.add(new JLabel("Person ID:"));
//        personIdField = new JTextField();
//        formPanel.add(personIdField);
//
//        JPanel buttonPanel = new JPanel();
//
//        JButton saveButton = new JButton("Save");
//        JButton updateButton = new JButton("Update");
//        JButton deleteButton = new JButton("Delete");
//        JButton getButton = new JButton("Get All");
//
//        buttonPanel.add(saveButton);
//        buttonPanel.add(updateButton);
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(getButton);
//
//        add(formPanel, BorderLayout.NORTH);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        // JTable for displaying transaction details
//        tableModel = new DefaultTableModel(new Object[]{"Product ID", "Quantity", "Selling Price", "Cumulative Price", "Price"}, 0);
//        transactionDetailsTable = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(transactionDetailsTable);
//        add(scrollPane, BorderLayout.CENTER);
//
//        saveButton.addActionListener(e -> saveTransaction());
//        updateButton.addActionListener(e -> updateTransaction());
//        deleteButton.addActionListener(e -> deleteTransaction());
//        getButton.addActionListener(e -> getAllTransactions());
//
//        setVisible(true);
//    }
//
//    private void saveTransaction() {
//        try {
//            Date transactionDate = transactionDateChooser.getDate();
//            double totalAmount = Double.parseDouble(totalAmountField.getText());
//            int salesRepresentativeId = Integer.parseInt(salesRepresentativeIdField.getText());
//            int personId = Integer.parseInt(personIdField.getText());
//
//            Transaction transaction = new Transaction();
//            transaction.setTransactionDate(transactionDate);
//            transaction.setTotalAmount(totalAmount);
//            transaction.setSalesRep(new Employee(salesRepresentativeId));
//            transaction.setPerson(new Person(personId));
//
//            transactionDAO.saveTransaction(transaction);
//
//            for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
//                int productId = Integer.parseInt(transactionDetailsTable.getValueAt(row, 0).toString());
//                double quantity = Double.parseDouble(transactionDetailsTable.getValueAt(row, 1).toString());
//                double sellingPrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 2).toString());
//                double cumulativePrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 3).toString());
//                double price = Double.parseDouble(transactionDetailsTable.getValueAt(row, 4).toString());
//
//                TransactionDetail transactionDetail = new TransactionDetail();
//                transactionDetail.setTransaction(transaction);
//                transactionDetail.setItem(new Item(productId));
//                transactionDetail.setQuantity(quantity);
//                transactionDetail.setSellingPrice(sellingPrice);
//                transactionDetail.setComulativePrice(cumulativePrice);
//                transactionDetail.setPrice(price);
//
//                transactionDetailDAO.saveTransactionDetail(transactionDetail);
//            }
//
//            JOptionPane.showMessageDialog(this, "Transaction saved successfully");
//            getAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void updateTransaction() {
//        try {
//            int transactionId = Integer.parseInt(transactionIdLabel.getText());
//            Date transactionDate = transactionDateChooser.getDate();
//            double totalAmount = Double.parseDouble(totalAmountField.getText());
//            int salesRepresentativeId = Integer.parseInt(salesRepresentativeIdField.getText());
//            int personId = Integer.parseInt(personIdField.getText());
//
//            Transaction transaction = transactionDAO.getTransactionById(transactionId);
//            if (transaction == null) {
//                JOptionPane.showMessageDialog(this, "Transaction not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            transaction.setTransactionDate(transactionDate);
//            transaction.setTotalAmount(totalAmount);
//            transaction.setSalesRep(new Employee(salesRepresentativeId));
//            transaction.setPerson(new Person(personId));
//
//            transactionDAO.updateTransaction(transaction);
//
//            // Update transaction details if needed (you can add logic to handle this part)
//
//            JOptionPane.showMessageDialog(this, "Transaction updated successfully");
//            getAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void deleteTransaction() {
//        try {
//            int transactionId = Integer.parseInt(transactionIdLabel.getText());
//
//            transactionDAO.deleteTransaction(transactionId);
//
//            JOptionPane.showMessageDialog(this, "Transaction deleted successfully");
//            getAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void getAllTransactions() {
//        List<Transaction> transactions = transactionDAO.getAllTransactions();
//        tableModel.setRowCount(0); // Clear existing data
//
//        for (Transaction transaction : transactions) {
//            for (TransactionDetail detail : transaction.getTransactionDetails()) {
//                tableModel.addRow(new Object[]{
//                        detail.getItem().getId(),
//                        detail.getQuantity(),
//                        detail.getSellingPrice(),
//                        detail.getComulativePrice(),
//                        detail.getPrice()
//                });
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(SalesForm::new);
//    }
//}
//
//

package gui;

import dao.TransactionDAO;
import dao.TransactionDetailDAO;
import entities.Transaction;
import entities.TransactionDetail;
import entities.Employee;
import entities.Item;
import entities.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class SalesForm extends JFrame {
    private JDateChooser transactionDateChooser;
    private JTextField totalAmountField;
    private JTextField salesRepresentativeIdField;
    private JTextField personIdField;
    private JTable transactionDetailsTable;
    private DefaultTableModel tableModel;
    private TransactionDAO transactionDAO;
    private TransactionDetailDAO transactionDetailDAO;
    private JLabel transactionIdLabel;

    public SalesForm() {
        transactionDAO = new TransactionDAO();
        transactionDetailDAO = new TransactionDetailDAO();

        setTitle("Record Sales Transaction");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));

        // Auto-generated transaction ID
        formPanel.add(new JLabel("Transaction ID:"));
        transactionIdLabel = new JLabel("Auto-generated");
        formPanel.add(transactionIdLabel);

        formPanel.add(new JLabel("Transaction Date:"));
        transactionDateChooser = new JDateChooser(new Date());
        formPanel.add(transactionDateChooser);

        formPanel.add(new JLabel("Total Amount:"));
        totalAmountField = new JTextField();
        formPanel.add(totalAmountField);

        formPanel.add(new JLabel("Sales Representative ID:"));
        salesRepresentativeIdField = new JTextField();
        formPanel.add(salesRepresentativeIdField);

        formPanel.add(new JLabel("Person ID:"));
        personIdField = new JTextField();
        formPanel.add(personIdField);

        JPanel buttonPanel = new JPanel();

        JButton saveButton = new JButton("Save");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton getButton = new JButton("Get All");

        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(getButton);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // JTable for displaying transaction details
        tableModel = new DefaultTableModel(new Object[]{"Product ID", "Quantity", "Selling Price", "Cumulative Price", "Price"}, 0);
        transactionDetailsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(transactionDetailsTable);
        add(scrollPane, BorderLayout.CENTER);

        saveButton.addActionListener(e -> saveTransaction());
        updateButton.addActionListener(e -> updateTransaction());
        deleteButton.addActionListener(e -> deleteTransaction());
        getButton.addActionListener(e -> getAllTransactions());

        setVisible(true);
    }

    private void saveTransaction() {
        try {
            Date transactionDate = transactionDateChooser.getDate();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            int salesRepresentativeId = Integer.parseInt(salesRepresentativeIdField.getText());
            int personId = Integer.parseInt(personIdField.getText());

            Transaction transaction = new Transaction();
            transaction.setTransactionDate(transactionDate);
            transaction.setTotalAmount(totalAmount);
            transaction.setSalesRep(new Employee(salesRepresentativeId));
            transaction.setPerson(new Person(personId));

            transactionDAO.saveTransaction(transaction);

            for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
                int productId = Integer.parseInt(transactionDetailsTable.getValueAt(row, 0).toString());
                double quantity = Double.parseDouble(transactionDetailsTable.getValueAt(row, 1).toString());
                double sellingPrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 2).toString());
                double cumulativePrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 3).toString());
                double price = Double.parseDouble(transactionDetailsTable.getValueAt(row, 4).toString());

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransaction(transaction);
                transactionDetail.setItem(new Item(productId));
                transactionDetail.setQuantity(quantity);
                transactionDetail.setSellingPrice(sellingPrice);
                transactionDetail.setComulativePrice(cumulativePrice);
                transactionDetail.setPrice(price);

                transactionDetailDAO.saveTransactionDetail(transactionDetail);
            }

            JOptionPane.showMessageDialog(this, "Transaction saved successfully");
            getAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdLabel.getText());
            Date transactionDate = transactionDateChooser.getDate();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            int salesRepresentativeId = Integer.parseInt(salesRepresentativeIdField.getText());
            int personId = Integer.parseInt(personIdField.getText());

            Transaction transaction = transactionDAO.getTransactionById(transactionId);
            if (transaction == null) {
                JOptionPane.showMessageDialog(this, "Transaction not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            transaction.setTransactionDate(transactionDate);
            transaction.setTotalAmount(totalAmount);
            transaction.setSalesRep(new Employee(salesRepresentativeId));
            transaction.setPerson(new Person(personId));

            transactionDAO.updateTransaction(transaction);

            // Update transaction details if needed (you can add logic to handle this part)

            JOptionPane.showMessageDialog(this, "Transaction updated successfully");
            getAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdLabel.getText());

            transactionDAO.deleteTransaction(transactionId);

            JOptionPane.showMessageDialog(this, "Transaction deleted successfully");
            getAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getAllTransactions() {
        List<Transaction> transactions = transactionDAO.getAllTransactions();
        tableModel.setRowCount(0); // Clear existing data

        for (Transaction transaction : transactions) {
            for (TransactionDetail detail : transaction.getTransactionDetails()) {
                tableModel.addRow(new Object[]{
                        detail.getItem().getId(),
                        detail.getQuantity(),
                        detail.getSellingPrice(),
                        detail.getComulativePrice(),
                        detail.getPrice()
                });
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesForm::new);
    }
}


