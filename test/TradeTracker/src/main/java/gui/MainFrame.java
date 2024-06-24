//package gui;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainFrame extends JFrame {
//    public MainFrame() {
//        setTitle("Trade Tracker");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JMenuBar menuBar = new JMenuBar();
//
//        JMenu manageMenu = new JMenu("Manage");
//        JMenuItem employeeItem = new JMenuItem("Employee");
//        JMenuItem personItem = new JMenuItem("Person");
//        JMenuItem phoneItem = new JMenuItem("Phone");
//        JMenuItem itemItem = new JMenuItem("Item");
//        JMenuItem transactionItem = new JMenuItem("Transaction");
//        JMenuItem purchaseTransactionItem = new JMenuItem("Purchase Transaction");
//        JMenuItem paymentItem = new JMenuItem("Payment");
//        JMenuItem purchaseDetailItem = new JMenuItem("Purchase Detail");
//        JMenuItem transactionDetailItem = new JMenuItem("Transaction Detail");
//
//        employeeItem.addActionListener(e -> new EmployeeForm());
//        personItem.addActionListener(e -> new PersonForm());
//        phoneItem.addActionListener(e -> new PhoneForm());
//        itemItem.addActionListener(e -> new ItemForm());
//        transactionItem.addActionListener(e -> new TransactionForm());
//        purchaseTransactionItem.addActionListener(e -> new PurchaseTransactionForm());
//        paymentItem.addActionListener(e -> new PaymentForm());
//        purchaseDetailItem.addActionListener(e -> new PurchaseDetailForm());
//        transactionDetailItem.addActionListener(e -> new TransactionDetailForm());
//
//        manageMenu.add(employeeItem);
//        manageMenu.add(personItem);
//        manageMenu.add(phoneItem);
//        manageMenu.add(itemItem);
//        manageMenu.add(transactionItem);
//        manageMenu.add(purchaseTransactionItem);
//        manageMenu.add(paymentItem);
//        manageMenu.add(purchaseDetailItem);
//        manageMenu.add(transactionDetailItem);
//
//        menuBar.add(manageMenu);
//
//        setJMenuBar(menuBar);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = new MainFrame();
//            mainFrame.setVisible(true);
//        });
//    }
//}

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JLabel totalTransactionsLabel;
    private JLabel totalCustomersLabel;
    private JLabel totalMoneyLabel;

    public MainFrame() {
        setTitle("Trade Tracker");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(42, 45, 53));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, getHeight()));

        String[] sidebarItems = {"E - Commerce", "IoT Dashboard", "Features", "Layout", "Forms", "UI Features", "Modal & Overlays", "Extra Component", "Maps", "Charts", "Editors", "Tables & Data", "Miscellaneous"};
        for (String item : sidebarItems) {
            JButton button = new JButton(item);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(60, 63, 65));
            button.setFocusPainted(false);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
            sidebar.add(button);
        }

        // Create Top Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu manageMenu = new JMenu("Manage");
        manageMenu.setForeground(Color.WHITE);

        String[] menuItems = {"Employee", "Person", "Phone", "Item", "Transaction", "Purchase Transaction", "Payment", "Purchase Detail", "Transaction Detail"};
        for (String item : menuItems) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.addActionListener(new MenuActionListener(item));
            manageMenu.add(menuItem);
        }

        menuBar.add(manageMenu);
        setJMenuBar(menuBar);

        // Create Dashboard
        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BorderLayout());
        dashboard.setBackground(Color.WHITE);

        // Create Top Panel for stats
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(1, 3, 10, 10));
        statsPanel.setBackground(Color.WHITE);

        totalTransactionsLabel = createStatLabel("Total Transactions: 0");
        totalCustomersLabel = createStatLabel("Total Customers: 0");
        totalMoneyLabel = createStatLabel("Total Money: $0");

        statsPanel.add(totalTransactionsLabel);
        statsPanel.add(totalCustomersLabel);
        statsPanel.add(totalMoneyLabel);

        dashboard.add(statsPanel, BorderLayout.NORTH);

        // Main content area with charts and tables
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2, 10, 10));
        contentPanel.setBackground(Color.WHITE);

        // Add some sample charts and tables
        contentPanel.add(createChartPanel("Contribution Bar Chart"));
        contentPanel.add(createChartPanel("Contribution Line Chart"));
        contentPanel.add(createChartPanel("Mobile Sales Pie Chart"));
        contentPanel.add(createTablePanel());
        contentPanel.add(createChartPanel("JFreeChart Histogram"));

        dashboard.add(contentPanel, BorderLayout.CENTER);

        // Add sidebar and dashboard to the main frame
        add(sidebar, BorderLayout.WEST);
        add(dashboard, BorderLayout.CENTER);
    }

    private JLabel createStatLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.DARK_GRAY);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        return label;
    }

    private JPanel createChartPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Placeholder for chart, replace with actual chart creation
        JLabel chartLabel = new JLabel(title, JLabel.CENTER);
        panel.add(chartLabel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("User Data"));
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        String[] columnNames = {"User Id", "User Name", "Email", "Contact No"};
        Object[][] data = {
                {1, "ABC", "ABC@GMAIL.COM", "1234567892"},
                {2, "XYZ", "XYZ@GMAIL.COM", "1234567892"},
                {3, "PQR", "PQR@GMAIL.COM", "1234567892"},
                {4, "MNO", "MNO@GMAIL.COM", "1234567892"},
                {5, "GSH", "GSH@GMAIL.COM", "1234567892"},
                {6, "JDG", "JDG@GMAIL.COM", "1234567892"},
                {7, "GSU", "GSU@GMAIL.COM", "1234567892"},
                {8, "JDI", "JDI@GMAIL.COM", "1234567892"},
                {9, "KLM", "KLM@GMAIL.COM", "1234567892"},
                {10, "NMO", "NMO@GMAIL.COM", "1234567892"},
        };

        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }

    class MenuActionListener implements ActionListener {
        private String formName;

        public MenuActionListener(String formName) {
            this.formName = formName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (formName) {
                case "Employee":
                    new EmployeeForm();
                    break;
                case "Person":
                    new PersonForm();
                    break;
                case "Phone":
                    new PhoneForm();
                    break;
                case "Item":
                    new ItemForm();
                    break;
                case "Transaction":
                    new TransactionForm();
                    break;
                case "Purchase Transaction":
                    new PurchaseTransactionForm();
                    break;
                case "Payment":
                    new PaymentForm();
                    break;
                case "Purchase Detail":
                    new PurchaseDetailForm();
                    break;
                case "Transaction Detail":
                    new TransactionDetailForm();
                    break;
                default:
                    break;
            }
        }
    }
}

