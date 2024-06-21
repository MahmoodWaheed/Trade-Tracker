package gui;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Trade Tracker");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu manageMenu = new JMenu("Manage");
        JMenuItem employeeItem = new JMenuItem("Employee");
        JMenuItem personItem = new JMenuItem("Person");
        JMenuItem phoneItem = new JMenuItem("Phone");
        JMenuItem itemItem = new JMenuItem("Item");
        JMenuItem transactionItem = new JMenuItem("Transaction");
        JMenuItem purchaseTransactionItem = new JMenuItem("Purchase Transaction");
        JMenuItem paymentItem = new JMenuItem("Payment");
        JMenuItem purchaseDetailItem = new JMenuItem("Purchase Detail");
        JMenuItem transactionDetailItem = new JMenuItem("Transaction Detail");

        employeeItem.addActionListener(e -> new EmployeeForm());
        personItem.addActionListener(e -> new PersonForm());
        phoneItem.addActionListener(e -> new PhoneForm());
        itemItem.addActionListener(e -> new ItemForm());
        transactionItem.addActionListener(e -> new TransactionForm());
        purchaseTransactionItem.addActionListener(e -> new PurchaseTransactionForm());
        paymentItem.addActionListener(e -> new PaymentForm());
        purchaseDetailItem.addActionListener(e -> new PurchaseDetailForm());
        transactionDetailItem.addActionListener(e -> new TransactionDetailForm());

        manageMenu.add(employeeItem);
        manageMenu.add(personItem);
        manageMenu.add(phoneItem);
        manageMenu.add(itemItem);
        manageMenu.add(transactionItem);
        manageMenu.add(purchaseTransactionItem);
        manageMenu.add(paymentItem);
        manageMenu.add(purchaseDetailItem);
        manageMenu.add(transactionDetailItem);

        menuBar.add(manageMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}


