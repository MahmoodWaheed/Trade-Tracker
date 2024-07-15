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


/*** her we need to modefy enter to down dwon ***/
//package gui;
//
//import dao.TransactionDAO;
//import dao.TransactionDetailDAO;
//import entities.Transaction;
//import entities.TransactionDetail;
//import entities.Item;
//import entities.Person;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableColumnModel;
//import javax.swing.table.TableModel;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.element.Cell;
//
//import com.toedter.calendar.JDateChooser;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyAdapter;
//import java.util.Date;
//import java.util.List;
//import java.util.ArrayList;
//
//public class SalesForm extends JFrame {
//    private JDateChooser transactionDateChooser;
//    private JTextField totalAmountField;
//    private JTextField personNameField;
//    private JTable transactionDetailsTable;
//    private DefaultTableModel tableModel;
//    private TransactionDAO transactionDAO;
//    private TransactionDetailDAO transactionDetailDAO;
//    private JTextField transactionIdField;
//    private JButton addNewTransactionButton;
//    private JButton saveButton, updateButton, deleteButton, prevButton, nextButton, printButton;
//
//    private List<Transaction> transactions = new ArrayList<>();
//    private int currentIndex = -1;
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
//        // Top panel
//        JPanel topPanel = new JPanel(new GridLayout(3, 2));
//        topPanel.setBackground(Color.decode("#E6F7FF"));
//
//        // Transaction ID
//        JLabel transactionIdLabel = new JLabel("Transaction ID:");
//        transactionIdLabel.setForeground(Color.decode("#0047AB"));
//        topPanel.add(transactionIdLabel);
//        transactionIdField = new JTextField("Auto-generated", 15);
//        transactionIdField.setEditable(false);
//        topPanel.add(transactionIdField);
//
//        // Person Name
//        JLabel personNameLabel = new JLabel("Person Name:");
//        personNameLabel.setForeground(Color.decode("#0047AB"));
//        topPanel.add(personNameLabel);
//        personNameField = new JTextField();
//        topPanel.add(personNameField);
//        AutoCompleteDecorator.decorate(personNameField, getPersonNames(), false);
//
//        // Transaction Date
//        JLabel transactionDateLabel = new JLabel("Transaction Date:");
//        transactionDateLabel.setForeground(Color.decode("#0047AB"));
//        topPanel.add(transactionDateLabel);
//        transactionDateChooser = new JDateChooser(new Date());
//        topPanel.add(transactionDateChooser);
//
//        add(topPanel, BorderLayout.NORTH);
//
//        // Table for transaction details
//        tableModel = new DefaultTableModel(new Object[]{"Product ID", "Quantity", "Selling Price", "Cumulative Price"}, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column != 3; // Make Cumulative Price column non-editable
//            }
//        };
//        transactionDetailsTable = new JTable(tableModel);
//
//        // Alternating row colors
//        transactionDetailsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                if (!isSelected) {
//                    c.setBackground(row % 2 == 0 ? Color.decode("#D9E6F5") : Color.WHITE);
//                }
//                return c;
//            }
//        });
//
//        // Enable Enter key navigation
//        enableEnterKeyNavigation(transactionDetailsTable);
//
//        JScrollPane scrollPane = new JScrollPane(transactionDetailsTable);
//        add(scrollPane, BorderLayout.CENTER);
//
//        // Bottom panel
//        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
//        bottomPanel.setBackground(Color.decode("#E6F7FF"));
//
//        JPanel totalAmountPanel = new JPanel(new GridLayout(1, 2));
//        totalAmountPanel.add(new JLabel("Total Amount:"));
//        totalAmountField = new JTextField();
//        totalAmountField.setEditable(false);
//        totalAmountPanel.add(totalAmountField);
//        bottomPanel.add(totalAmountPanel);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBackground(Color.decode("#E6F7FF"));
//        saveButton = new JButton("Save");
//        saveButton.setBackground(Color.decode("#0047AB"));
//        saveButton.setForeground(Color.WHITE);
//        updateButton = new JButton("Update");
//        updateButton.setBackground(Color.decode("#0047AB"));
//        updateButton.setForeground(Color.WHITE);
//        deleteButton = new JButton("Delete");
//        deleteButton.setBackground(Color.decode("#0047AB"));
//        deleteButton.setForeground(Color.WHITE);
//        prevButton = new JButton("Previous");
//        prevButton.setBackground(Color.decode("#0047AB"));
//        prevButton.setForeground(Color.WHITE);
//        nextButton = new JButton("Next");
//        nextButton.setBackground(Color.decode("#0047AB"));
//        nextButton.setForeground(Color.WHITE);
//        printButton = new JButton("Print");
//        printButton.setBackground(Color.decode("#0047AB"));
//        printButton.setForeground(Color.WHITE);
//
//        buttonPanel.add(saveButton);
//        buttonPanel.add(updateButton);
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(prevButton);
//        buttonPanel.add(nextButton);
//        buttonPanel.add(printButton);
//        bottomPanel.add(buttonPanel);
//
//        add(bottomPanel, BorderLayout.SOUTH);
//
//        addNewTransactionButton = new JButton("Add New Transaction");
//        addNewTransactionButton.setBackground(Color.decode("#0047AB"));
//        addNewTransactionButton.setForeground(Color.WHITE);
//        addNewTransactionButton.addActionListener(e -> addNewTransaction());
//        buttonPanel.add(addNewTransactionButton);
//
//        saveButton.addActionListener(e -> saveTransaction());
//        updateButton.addActionListener(e -> updateTransaction());
//        deleteButton.addActionListener(e -> deleteTransaction());
//        prevButton.addActionListener(e -> getPreviousTransaction());
//        nextButton.addActionListener(e -> getNextTransaction());
//        printButton.addActionListener(e -> printTransaction());
//
//        // Adding Table model listener for cumulative price calculation
//        tableModel.addTableModelListener(e -> {
//            int column = e.getColumn();
//            if (column == 1 || column == 2) {
//                updateCumulativePrice();
//            }
//            calculateTotalAmount();
//        });
//
//        setVisible(true);
//        loadAllTransactions();
//    }
//
//    private void addNewTransaction() {
//        clearFields();
//        transactionIdField.setText("Auto-generated");
//
//        // Ensure there is at least one initial row in the table
//        if (tableModel.getRowCount() == 0) {
//            tableModel.addRow(new Object[]{"", 0, 0.0, 0.0});
//        }
//    }
//
//    private void updateCumulativePrice() {
//        for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
//            double quantity = getDoubleValueAt(row, 1);
//            double sellingPrice = getDoubleValueAt(row, 2);
//            double cumulativePrice = quantity * sellingPrice;
//            transactionDetailsTable.setValueAt(cumulativePrice, row, 3);
//        }
//    }
//
//    private double getDoubleValueAt(int row, int column) {
//        try {
//            return Double.parseDouble(transactionDetailsTable.getValueAt(row, column).toString());
//        } catch (NumberFormatException | NullPointerException e) {
//            return 0.0;
//        }
//    }
//
//    private void calculateTotalAmount() {
//        double totalAmount = 0;
//        for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
//            totalAmount += getDoubleValueAt(row, 3);
//        }
//        totalAmountField.setText(String.valueOf(totalAmount));
//    }
//
//    private void saveTransaction() {
//        try {
//            Date transactionDate = transactionDateChooser.getDate();
//            calculateTotalAmount();
//            double totalAmount = Double.parseDouble(totalAmountField.getText());
//            String personName = personNameField.getText();
//
//            Person person = transactionDAO.getPersonByName(personName);
//            if (person == null) {
//                JOptionPane.showMessageDialog(this, "Person not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            Transaction transaction = new Transaction();
//            transaction.setTransactionDate(transactionDate);
//            transaction.setTotalAmount(totalAmount);
//            transaction.setPerson(person);
//
//            transactionDAO.saveTransaction(transaction);
//
//            for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
//                int productId = getIntValueAt(row, 0);
//                double quantity = getDoubleValueAt(row, 1);
//                double sellingPrice = getDoubleValueAt(row, 2);
//                double cumulativePrice = getDoubleValueAt(row, 3);
//
//                TransactionDetail transactionDetail = new TransactionDetail();
//                transactionDetail.setTransaction(transaction);
//                transactionDetail.setItem(new Item(productId));
//                transactionDetail.setQuantity(quantity);
//                transactionDetail.setSellingPrice(sellingPrice);
//                transactionDetail.setComulativePrice(cumulativePrice);
//
//                transactionDetailDAO.saveTransactionDetail(transactionDetail);
//            }
//
//            JOptionPane.showMessageDialog(this, "Transaction saved successfully");
//            loadAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error saving transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private int getIntValueAt(int row, int column) {
//        try {
//            return Integer.parseInt(transactionDetailsTable.getValueAt(row, column).toString());
//        } catch (NumberFormatException | NullPointerException e) {
//            return 0;
//        }
//    }
//
//    private void updateTransaction() {
//        try {
//            int transactionId = Integer.parseInt(transactionIdField.getText());
//            Date transactionDate = transactionDateChooser.getDate();
//            calculateTotalAmount();
//            double totalAmount = Double.parseDouble(totalAmountField.getText());
//            String personName = personNameField.getText();
//
//            Person person = transactionDAO.getPersonByName(personName);
//            if (person == null) {
//                JOptionPane.showMessageDialog(this, "Person not found", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            Transaction transaction = transactionDAO.getTransactionById(transactionId);
//            transaction.setTransactionDate(transactionDate);
//            transaction.setTotalAmount(totalAmount);
//            transaction.setPerson(person);
//
//            transactionDAO.updateTransaction(transaction);
//
//            // You can add code to update transaction details if needed (you can add logic to handle this part)
//
//            JOptionPane.showMessageDialog(this, "Transaction updated successfully");
//            loadAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void deleteTransaction() {
//        try {
//            int transactionId = Integer.parseInt(transactionIdField.getText());
//
//            transactionDAO.deleteTransaction(transactionId);
//
//            JOptionPane.showMessageDialog(this, "Transaction deleted successfully");
//            loadAllTransactions(); // Refresh table data
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void getPreviousTransaction() {
//        if (currentIndex > 0) {
//            currentIndex--;
//            showTransaction(transactions.get(currentIndex));
//        }
//    }
//
//    private void getNextTransaction() {
//        if (currentIndex < transactions.size() - 1) {
//            currentIndex++;
//            showTransaction(transactions.get(currentIndex));
//        }
//    }
//
//    private void loadAllTransactions() {
//        try {
//            transactions = transactionDAO.getAllTransactions();
//            if (!transactions.isEmpty()) {
//                currentIndex = 0;
//                showTransaction(transactions.get(currentIndex));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error fetching transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void showTransaction(Transaction transaction) {
//        transactionIdField.setText(String.valueOf(transaction.getId()));
//        transactionDateChooser.setDate(transaction.getTransactionDate());
//        personNameField.setText(transaction.getPerson().getName());
//        totalAmountField.setText(String.valueOf(transaction.getTotalAmount()));
//
//        tableModel.setRowCount(0); // Clear existing rows
//        for (TransactionDetail detail : transaction.getTransactionDetails()) {
//            tableModel.addRow(new Object[]{
//                    detail.getItem().getId(),
//                    detail.getQuantity(),
//                    detail.getSellingPrice(),
//                    detail.getComulativePrice()
//            });
//        }
//    }
//
//    private void printTransaction() {
//        if (currentIndex < 0 || currentIndex >= transactions.size()) {
//            JOptionPane.showMessageDialog(this, "No transaction selected", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        Transaction transaction = transactions.get(currentIndex);
//
//        String dest = "Transaction_" + transaction.getId() + ".pdf";
//
//        try {
//            PdfWriter writer = new PdfWriter(dest);
//            PdfDocument pdfDoc = new PdfDocument(writer);
//            Document document = new Document(pdfDoc);
//
//            document.add(new Paragraph("Transaction Details"));
//            document.add(new Paragraph("Transaction ID: " + transaction.getId()));
//            document.add(new Paragraph("Transaction Date: " + transaction.getTransactionDate()));
//            document.add(new Paragraph("Person Name: " + transaction.getPerson().getName()));
//            document.add(new Paragraph("Total Amount: " + transaction.getTotalAmount()));
//
//            document.add(new Paragraph("Transaction Items:"));
//
//            Table table = new Table(new float[]{1, 2, 2, 2});
//            table.addHeaderCell(new Cell().add(new Paragraph("Product ID")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Quantity")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Selling Price")));
//            table.addHeaderCell(new Cell().add(new Paragraph("Cumulative Price")));
//
//            for (TransactionDetail detail : transaction.getTransactionDetails()) {
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getItem().getId()))));
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getQuantity()))));
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getSellingPrice()))));
//                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getComulativePrice()))));
//            }
//
//            document.add(table);
//
//            document.close();
//
//            JOptionPane.showMessageDialog(this, "Transaction printed successfully to " + dest);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error printing transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private List<String> getPersonNames() {
//        List<String> personNames = new ArrayList<>();
//        try {
//            List<Person> persons = transactionDAO.getAllPersons();
//            for (Person person : persons) {
//                personNames.add(person.getName());
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error fetching person names: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return personNames;
//    }
//
//    private void clearFields() {
//        transactionIdField.setText("Auto-generated");
//        personNameField.setText("");
//        transactionDateChooser.setDate(new Date());
//        totalAmountField.setText("");
//    }
//
//    private void enableEnterKeyNavigation(JTable table) {
//        table.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    int selectedRow = table.getSelectedRow();
//                    int selectedColumn = table.getSelectedColumn();
//
//                    // Move left within the row
//                    if (selectedColumn > 0) {
//                        table.setColumnSelectionInterval(selectedColumn - 1, selectedColumn - 1);
//                    } else {
//                        // Move down to a new row
//                        if (selectedRow < table.getRowCount() - 1) {
//                            table.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
//                            table.setColumnSelectionInterval(0, 0);
//                        }
//                    }
//                }
//            }
//        });
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;

import com.toedter.calendar.JDateChooser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class SalesForm extends JFrame {
    private JDateChooser transactionDateChooser;
    private JTextField totalAmountField;
    private JTextField personNameField;
    private JTable transactionDetailsTable;
    private DefaultTableModel tableModel;
    private TransactionDAO transactionDAO;
    private TransactionDetailDAO transactionDetailDAO;
    private JTextField transactionIdField;
    private JButton addNewTransactionButton;
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
        // Add a TableModelListener to update the cumulative price automatically
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 0 || column == 1 || column == 2) { // Product ID, Quantity, Selling Price columns
                        updateCumulativePrice(row);
                        calculateTotalAmount();
                    }
                }
            }
        });

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


        // Enable Enter key navigation
        enableEnterKeyNavigation(transactionDetailsTable);

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

        addNewTransactionButton = new JButton("Add New Transaction");
        saveButton = new JButton("Save");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        printButton = new JButton("Print");

        addNewTransactionButton.setBackground(Color.decode("#0047AB"));
        addNewTransactionButton.setForeground(Color.WHITE);
        saveButton.setBackground(Color.decode("#0047AB"));
        saveButton.setForeground(Color.WHITE);
        updateButton.setBackground(Color.decode("#0047AB"));
        updateButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.decode("#0047AB"));
        deleteButton.setForeground(Color.WHITE);
        prevButton.setBackground(Color.decode("#0047AB"));
        prevButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.decode("#0047AB"));
        nextButton.setForeground(Color.WHITE);
        printButton.setBackground(Color.decode("#0047AB"));
        printButton.setForeground(Color.WHITE);

        buttonPanel.add(addNewTransactionButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(printButton);

        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        addNewTransactionButton.addActionListener(e -> clearFields());

        saveButton.addActionListener(e -> saveTransaction());

        updateButton.addActionListener(e -> updateTransaction());

        deleteButton.addActionListener(e -> deleteTransaction());

        prevButton.addActionListener(e -> getPreviousTransaction());

        nextButton.addActionListener(e -> getNextTransaction());

        printButton.addActionListener(e -> printTransaction());

        loadAllTransactions();

        setVisible(true);
    }
    private void updateCumulativePrice(int row) {
        double quantity = getDoubleValueAt(row, 1);
        double sellingPrice = getDoubleValueAt(row, 2);
        double cumulativePrice = quantity * sellingPrice;
        transactionDetailsTable.setValueAt(cumulativePrice, row, 3);
    }

    private void calculateTotalAmount() {
        double totalAmount = 0.0;
        for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
            double quantity = getDoubleValueAt(row, 1);
            double sellingPrice = getDoubleValueAt(row, 2);
            double cumulativePrice = quantity * sellingPrice;
            transactionDetailsTable.setValueAt(cumulativePrice, row, 3);
            totalAmount += cumulativePrice;
        }
        totalAmountField.setText(String.valueOf(totalAmount));
    }

    private double getDoubleValueAt(int row, int column) {
        try {
            return Double.parseDouble(transactionDetailsTable.getValueAt(row, column).toString());
        } catch (NumberFormatException | NullPointerException e) {
            return 0.0;
        }
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
                int productId = getIntValueAt(row, 0);
                double quantity = getDoubleValueAt(row, 1);
                double sellingPrice = getDoubleValueAt(row, 2);
                double cumulativePrice = getDoubleValueAt(row, 3);

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransaction(transaction);
                transactionDetail.setItem(new Item(productId));
                transactionDetail.setQuantity(quantity);
                transactionDetail.setSellingPrice(sellingPrice);
                transactionDetail.setCumulativePrice(cumulativePrice);

                transactionDetailDAO.saveTransactionDetail(transactionDetail);
            }

            JOptionPane.showMessageDialog(this, "Transaction saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAllTransactions();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            if (transaction == null) {
                JOptionPane.showMessageDialog(this, "Transaction not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            transaction.setTransactionDate(transactionDate);
            transaction.setTotalAmount(totalAmount);
            transaction.setPerson(person);

            transactionDAO.updateTransaction(transaction);

            transactionDetailDAO.deleteTransactionDetailsByTransactionId(transactionId);

            for (int row = 0; row < transactionDetailsTable.getRowCount(); row++) {
                int productId = getIntValueAt(row, 0);
                double quantity = getDoubleValueAt(row, 1);
                double sellingPrice = getDoubleValueAt(row, 2);
                double cumulativePrice = getDoubleValueAt(row, 3);

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransaction(transaction);
                transactionDetail.setItem(new Item(productId));
                transactionDetail.setQuantity(quantity);
                transactionDetail.setSellingPrice(sellingPrice);
                transactionDetail.setCumulativePrice(cumulativePrice);

                transactionDetailDAO.saveTransactionDetail(transactionDetail);
            }

            JOptionPane.showMessageDialog(this, "Transaction updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAllTransactions();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getIntValueAt(int row, int column) {
        try {
            return Integer.parseInt(transactionDetailsTable.getValueAt(row, column).toString());
        } catch (NumberFormatException | NullPointerException e) {
            return 0;
        }
    }

    private void deleteTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdField.getText());
            transactionDAO.deleteTransaction(transactionId);
            transactionDetailDAO.deleteTransactionDetailsByTransactionId(transactionId);
            JOptionPane.showMessageDialog(this, "Transaction deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadAllTransactions();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getPreviousTransaction() {
        if (currentIndex > 0) {
            currentIndex--;
            loadTransaction(transactions.get(currentIndex));
        }
    }

    private void getNextTransaction() {
        if (currentIndex < transactions.size() - 1) {
            currentIndex++;
            loadTransaction(transactions.get(currentIndex));
        }
    }

    private void loadTransaction(Transaction transaction) {
        transactionIdField.setText(String.valueOf(transaction.getId()));
        transactionDateChooser.setDate(transaction.getTransactionDate());
        totalAmountField.setText(String.valueOf(transaction.getTotalAmount()));
        personNameField.setText(transaction.getPerson().getName());

        tableModel.setRowCount(0);
        List<TransactionDetail> details = transactionDetailDAO.getTransactionDetailsByTransactionId(transaction.getId());
        for (TransactionDetail detail : details) {
            tableModel.addRow(new Object[]{
                    detail.getItem().getId(),
                    detail.getQuantity(),
                    detail.getSellingPrice(),
                    detail.getComulativePrice()
            });
        }
    }

    private void loadAllTransactions() {
        transactions = transactionDAO.getAllTransactions();
        currentIndex = transactions.size() - 1;
        if (currentIndex >= 0) {
            loadTransaction(transactions.get(currentIndex));
        }
    }

    private void printTransaction() {
        try {
            int transactionId = Integer.parseInt(transactionIdField.getText());
            Transaction transaction = transactionDAO.getTransactionById(transactionId);
            List<TransactionDetail> details = transactionDetailDAO.getTransactionDetailsByTransactionId(transactionId);

            PdfWriter writer = new PdfWriter("Transaction_" + transactionId + ".pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Transaction ID: " + transaction.getId()));
            document.add(new Paragraph("Transaction Date: " + transaction.getTransactionDate()));
            document.add(new Paragraph("Person Name: " + transaction.getPerson().getName()));
            document.add(new Paragraph("Total Amount: " + transaction.getTotalAmount()));

            Table table = new Table(4);
            table.addCell(new Cell().add(new Paragraph("Product ID") ));
            table.addCell(new Cell().add( new Paragraph("Quantity")));
            table.addCell(new Cell().add(new Paragraph("Selling Price")));
            table.addCell(new Cell().add(new Paragraph("Cumulative Price")));

            for (TransactionDetail detail : details) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getItem().getId()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getQuantity()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getSellingPrice()))));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getComulativePrice()))));
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(this, "Transaction printed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error printing transaction: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        transactionIdField.setText("Auto-generated");
        transactionDateChooser.setDate(new Date());
        personNameField.setText("");
        totalAmountField.setText("");
        tableModel.setRowCount(0);
        currentIndex = -1;
    }

    private List<String> getPersonNames() {
        return transactionDAO.getAllPersonNames();
    }

    private void enableEnterKeyNavigation(JTable table) {
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    if (table.getCellEditor() != null) {
                        table.getCellEditor().stopCellEditing();
                    }
                    if (column == table.getColumnCount() - 1) {
                        column = 0;
                        row++;
                    } else {
                        column++;
                    }
                    if (row == table.getRowCount()) {
                        tableModel.addRow(new Object[table.getColumnCount()]);
                    }
                    table.changeSelection(row, column, false, false);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesForm::new);
    }
}















