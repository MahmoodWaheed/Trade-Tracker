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
//
//package gui;
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
//    private JLabel transactionIdLabel;
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
//        transactionIdLabel = new JLabel("Auto-generated");
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

package gui;

import dao.TransactionDAO;
import dao.TransactionDetailDAO;
import entities.Transaction;
import entities.TransactionDetail;
import entities.Item;
import entities.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import com.toedter.calendar.JDateChooser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class SalesForm extends JFrame {
    private JDateChooser transactionDateChooser;
    private JTextField totalAmountField;
    private JTextField personNameField;
    private JTable transactionDetailsTable;
    private DefaultTableModel tableModel;
    private TransactionDAO transactionDAO;
    private TransactionDetailDAO transactionDetailDAO;
    private JTextField transactionIdField;
    private JButton addRowButton;
    private JButton saveButton, updateButton, deleteButton, prevButton, nextButton, printButton;

    private List<Transaction> transactions = new ArrayList<>();
    private int currentIndex = -1;

    public SalesForm() {
        transactionDAO = new TransactionDAO();
        transactionDetailDAO = new TransactionDetailDAO();

        setTitle("Record Sales Transaction");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        topPanel.setBackground(Color.decode("#E6F7FF"));

        // Transaction ID
        JLabel transactionIdLabel = new JLabel("Transaction ID:");
        transactionIdLabel.setForeground(Color.decode("#0047AB"));
        topPanel.add(transactionIdLabel);
        transactionIdField = new JTextField("Auto-generated", 15);
        transactionIdField.setEditable(false);
        topPanel.add(transactionIdField);

        // Person Name
        JLabel personNameLabel = new JLabel("Person Name:");
        personNameLabel.setForeground(Color.decode("#0047AB"));
        topPanel.add(personNameLabel);
        personNameField = new JTextField();
        topPanel.add(personNameField);
        AutoCompleteDecorator.decorate(personNameField, getPersonNames(), false);

        // Transaction Date
        JLabel transactionDateLabel = new JLabel("Transaction Date:");
        transactionDateLabel.setForeground(Color.decode("#0047AB"));
        topPanel.add(transactionDateLabel);
        transactionDateChooser = new JDateChooser(new Date());
        topPanel.add(transactionDateChooser);

        add(topPanel, BorderLayout.NORTH);

        // Table for transaction details
        tableModel = new DefaultTableModel(new Object[]{"Product ID", "Quantity", "Selling Price", "Cumulative Price"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 3; // Make Cumulative Price column non-editable
            }
        };
        transactionDetailsTable = new JTable(tableModel);

        // Alternating row colors
        transactionDetailsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.decode("#D9E6F5") : Color.WHITE);
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(transactionDetailsTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.setBackground(Color.decode("#E6F7FF"));

        JPanel totalAmountPanel = new JPanel(new GridLayout(1, 2));
        totalAmountPanel.add(new JLabel("Total Amount:"));
        totalAmountField = new JTextField();
        totalAmountField.setEditable(false);
        totalAmountPanel.add(totalAmountField);
        bottomPanel.add(totalAmountPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#E6F7FF"));
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.decode("#0047AB"));
        saveButton.setForeground(Color.WHITE);
        updateButton = new JButton("Update");
        updateButton.setBackground(Color.decode("#0047AB"));
        updateButton.setForeground(Color.WHITE);
        deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.decode("#0047AB"));
        deleteButton.setForeground(Color.WHITE);
        prevButton = new JButton("Previous");
        prevButton.setBackground(Color.decode("#0047AB"));
        prevButton.setForeground(Color.WHITE);
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.decode("#0047AB"));
        nextButton.setForeground(Color.WHITE);
        printButton = new JButton("Print");
        printButton.setBackground(Color.decode("#0047AB"));
        printButton.setForeground(Color.WHITE);

        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(printButton);
        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        addRowButton = new JButton("Add Row");
        addRowButton.setBackground(Color.decode("#0047AB"));
        addRowButton.setForeground(Color.WHITE);
        addRowButton.addActionListener(e -> addRow());
        buttonPanel.add(addRowButton);

        saveButton.addActionListener(e -> saveTransaction());
        updateButton.addActionListener(e -> updateTransaction());
        deleteButton.addActionListener(e -> deleteTransaction());
        prevButton.addActionListener(e -> getPreviousTransaction());
        nextButton.addActionListener(e -> getNextTransaction());
        printButton.addActionListener(e -> printTransaction());

        // Adding Table model listener for cumulative price calculation
        tableModel.addTableModelListener(e -> {
            int column = e.getColumn();
            if (column == 1 || column == 2) {
                updateCumulativePrice();
            }
            calculateTotalAmount();
        });

        setVisible(true);
        loadAllTransactions();
    }

    private void addRow() {
        tableModel.addRow(new Object[]{"", "", "", ""});
    }

    private void updateCumulativePrice() {
        for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
            double quantity = Double.parseDouble(transactionDetailsTable.getValueAt(row, 1).toString());
            double sellingPrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 2).toString());
            double cumulativePrice = quantity * sellingPrice;
            transactionDetailsTable.setValueAt(cumulativePrice, row, 3);
        }
    }

    private void calculateTotalAmount() {
        double totalAmount = 0;
        for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
            double cumulativePrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 3).toString());
            totalAmount += cumulativePrice;
        }
        totalAmountField.setText(String.valueOf(totalAmount));
    }

    private void saveTransaction() {
        try {
            Date transactionDate = transactionDateChooser.getDate();
            calculateTotalAmount();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            String personName = personNameField.getText();

            Person person = transactionDAO.getPersonByName(personName);
            if (person == null) {
                JOptionPane.showMessageDialog(this, "Person not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Transaction transaction = new Transaction();
            transaction.setTransactionDate(transactionDate);
            transaction.setTotalAmount(totalAmount);
            transaction.setPerson(person);

            transactionDAO.saveTransaction(transaction);

            for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
                int productId = Integer.parseInt(transactionDetailsTable.getValueAt(row, 0).toString());
                double quantity = Double.parseDouble(transactionDetailsTable.getValueAt(row, 1).toString());
                double sellingPrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 2).toString());
                double cumulativePrice = Double.parseDouble(transactionDetailsTable.getValueAt(row, 3).toString());

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransaction(transaction);
                transactionDetail.setItem(new Item(productId));
                transactionDetail.setQuantity(quantity);
                transactionDetail.setSellingPrice(sellingPrice);
                transactionDetail.setComulativePrice(cumulativePrice);

                transactionDetailDAO.saveTransactionDetail(transactionDetail);
            }

            JOptionPane.showMessageDialog(this, "Transaction saved successfully");
            loadAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdField.getText());
            Date transactionDate = transactionDateChooser.getDate();
            calculateTotalAmount();
            double totalAmount = Double.parseDouble(totalAmountField.getText());
            String personName = personNameField.getText();

            Person person = transactionDAO.getPersonByName(personName);
            if (person == null) {
                JOptionPane.showMessageDialog(this, "Person not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Transaction transaction = transactionDAO.getTransactionById(transactionId);
            transaction.setTransactionDate(transactionDate);
            transaction.setTotalAmount(totalAmount);
            transaction.setPerson(person);

            transactionDAO.updateTransaction(transaction);

            // You can add code to update transaction details if needed (you can add logic to handle this part)

            JOptionPane.showMessageDialog(this, "Transaction updated successfully");
            loadAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdField.getText());

            transactionDAO.deleteTransaction(transactionId);

            JOptionPane.showMessageDialog(this, "Transaction deleted successfully");
            loadAllTransactions(); // Refresh table data
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getPreviousTransaction() {
        if (currentIndex > 0) {
            currentIndex--;
            showTransaction(transactions.get(currentIndex));
        }
    }

    private void getNextTransaction() {
        if (currentIndex < transactions.size() - 1) {
            currentIndex++;
            showTransaction(transactions.get(currentIndex));
        }
    }

    private void loadAllTransactions() {
        try {
            transactions = transactionDAO.getAllTransactions();
            if (!transactions.isEmpty()) {
                currentIndex = 0;
                showTransaction(transactions.get(currentIndex));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showTransaction(Transaction transaction) {
        transactionIdField.setText(String.valueOf(transaction.getId()));
        transactionDateChooser.setDate(transaction.getTransactionDate());
        personNameField.setText(transaction.getPerson().getName());
        totalAmountField.setText(String.valueOf(transaction.getTotalAmount()));

        tableModel.setRowCount(0); // Clear existing rows
        for (TransactionDetail detail : transaction.getTransactionDetails()) {
            tableModel.addRow(new Object[]{
                    detail.getItem().getId(),
                    detail.getQuantity(),
                    detail.getSellingPrice(),
                    detail.getComulativePrice()
            });
        }
    }

    private void printTransaction() {
        // Implement the print functionality using a library like iText
    }

    private List<String> getPersonNames() {
        List<String> personNames = new ArrayList<>();
        try {
            List<Person> persons = transactionDAO.getAllPersons();
            for (Person person : persons) {
                personNames.add(person.getName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching person names: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return personNames;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesForm::new);
    }
}












