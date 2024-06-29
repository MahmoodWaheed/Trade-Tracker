//package gui;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class EmployeeForm extends JFrame {
//    public EmployeeForm() {
//        setTitle("Manage Employees");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        setLayout(new BorderLayout());
//
//        JPanel formPanel = new JPanel(new GridLayout(4, 2));
//
//        formPanel.add(new JLabel("Name:"));
//        JTextField nameField = new JTextField();
//        formPanel.add(nameField);
//
//        formPanel.add(new JLabel("Role:"));
//        JTextField roleField = new JTextField();
//        formPanel.add(roleField);
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
//            // Implement save logic using EmployeeDAO
//        });
//
//        updateButton.addActionListener(e -> {
//            // Implement update logic using EmployeeDAO
//        });
//
//        deleteButton.addActionListener(e -> {
//            // Implement delete logic using EmployeeDAO
//        });
//
//        getButton.addActionListener(e -> {
//            // Implement get logic using EmployeeDAO
//        });
//
//        setVisible(true);
//    }
//}




/** to export pdf */
//////////////////////////////////////////////////////////
//package gui;
//
//import dao.EmployeeDAO;
//import entities.Employee;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class EmployeeForm extends JFrame {
//    private JTextField nameField;
//    private JTextField roleField;
//    private EmployeeDAO employeeDAO;
//
//    public EmployeeForm() {
//        employeeDAO = new EmployeeDAO();
//
//        setTitle("Manage Employees");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        setLayout(new BorderLayout());
//
//        JPanel formPanel = new JPanel(new GridLayout(3, 2));
//
//        formPanel.add(new JLabel("Name:"));
//        nameField = new JTextField();
//        formPanel.add(nameField);
//
//        formPanel.add(new JLabel("Role:"));
//        roleField = new JTextField();
//        formPanel.add(roleField);
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
//        add(formPanel, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        saveButton.addActionListener(e -> saveEmployee());
//        updateButton.addActionListener(e -> updateEmployee());
//        deleteButton.addActionListener(e -> deleteEmployee());
//        getButton.addActionListener(e -> getAllEmployees());
//
//        setVisible(true);
//    }
//
//    private void saveEmployee() {
//        try {
//            String name = nameField.getText();
//            String role = roleField.getText();
//
//            Employee employee = new Employee();
//            employee.setName(name);
//            employee.setRole(role);
//
//            employeeDAO.saveEmployee(employee);
//            JOptionPane.showMessageDialog(this, "Employee saved successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving employee: " + e.getMessage());
//        }
//    }
//
//    private void updateEmployee() {
//        try {
//            // Implement update logic using EmployeeDAO
//            JOptionPane.showMessageDialog(this, "Update button clicked");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error updating employee: " + e.getMessage());
//        }
//    }
//
//    private void deleteEmployee() {
//        try {
//            // Implement delete logic using EmployeeDAO
//            JOptionPane.showMessageDialog(this, "Delete button clicked");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error deleting employee: " + e.getMessage());
//        }
//    }
//
//    private void getAllEmployees() {
//        try {
//            List<Employee> employees = employeeDAO.getAllEmployees();
//            if (employees != null) {
//                StringBuilder sb = new StringBuilder();
//                for (Employee employee : employees) {
//                    sb.append("ID: ").append(employee.getId())
//                            .append(", Name: ").append(employee.getName())
//                            .append(", Role: ").append(employee.getRole())
//                            .append("\n");
//                }
//                JOptionPane.showMessageDialog(this, sb.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error retrieving employees: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        new EmployeeForm();
//    }
//}

/*** export edited Pdf***/
//package gui;
//
//import dao.EmployeeDAO;
//import entities.Employee;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.util.List;
//import java.io.File;
//import java.io.FileOutputStream;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.PdfPCell; // Missing import
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Phrase;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//
//public class EmployeeForm extends JFrame {
//    private JTextField nameField;
//    private JTextField roleField;
//    private JTable employeeTable;
//    private DefaultTableModel tableModel;
//    private EmployeeDAO employeeDAO;
//
//    public EmployeeForm() {
//        employeeDAO = new EmployeeDAO();
//
//        setTitle("Manage Employees");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        setLayout(new BorderLayout());
//
//        JPanel formPanel = new JPanel(new GridLayout(3, 2));
//
//        formPanel.add(new JLabel("Name:"));
//        nameField = new JTextField();
//        formPanel.add(nameField);
//
//        formPanel.add(new JLabel("Role:"));
//        roleField = new JTextField();
//        formPanel.add(roleField);
//
//        JPanel buttonPanel = new JPanel();
//
//        JButton saveButton = new JButton("Save");
//        JButton updateButton = new JButton("Update");
//        JButton deleteButton = new JButton("Delete");
//        JButton getButton = new JButton("Get All");
//        JButton exportButton = new JButton("Export to PDF");
//        JButton getById = new JButton("Get Employee by Id");
//
//        buttonPanel.add(saveButton);
//        buttonPanel.add(updateButton);
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(getButton);
//        buttonPanel.add(exportButton);
//        buttonPanel.add(getById);
//
//        add(formPanel, BorderLayout.NORTH);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        // JTable for displaying employee data
//        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Role"}, 0);
//        employeeTable = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(employeeTable);
//        add(scrollPane, BorderLayout.CENTER);
//
//        saveButton.addActionListener(e -> saveEmployee());
//        updateButton.addActionListener(e -> updateEmployee());
//        deleteButton.addActionListener(e -> deleteEmployee());
//        getButton.addActionListener(e -> getAllEmployees());
//        exportButton.addActionListener(e -> exportToPDF());
//
//        setVisible(true);
//    }
//
//    private void saveEmployee() {
//        try {
//            String name = nameField.getText();
//            String role = roleField.getText();
//
//            Employee employee = new Employee();
//            employee.setName(name);
//            employee.setRole(role);
//
//            employeeDAO.saveEmployee(employee);
//            JOptionPane.showMessageDialog(this, "Employee saved successfully");
//            getAllEmployees(); // Refresh table data
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error saving employee: " + e.getMessage());
//        }
//    }
//
//    private void updateEmployee() {
//        try {
//            // Implement update logic using EmployeeDAO
//            JOptionPane.showMessageDialog(this, "Update button clicked");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error updating employee: " + e.getMessage());
//        }
//    }
//
//    private void deleteEmployee() {
//        try {
//            // Implement delete logic using EmployeeDAO
//            JOptionPane.showMessageDialog(this, "Delete button clicked");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error deleting employee: " + e.getMessage());
//        }
//    }
//
//    private void getAllEmployees() {
//        try {
//            List<Employee> employees = employeeDAO.getAllEmployees();
//            tableModel.setRowCount(0); // Clear existing data
//            if (employees != null) {
//                for (Employee employee : employees) {
//                    tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getRole()});
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error retrieving employees: " + e.getMessage());
//        }
//    }
//
//    private void exportToPDF() {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDialogTitle("Specify a file to save");
//        int userSelection = fileChooser.showSaveDialog(this);
//
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            File fileToSave = fileChooser.getSelectedFile();
//            if (!fileToSave.getAbsolutePath().endsWith(".pdf")) {
//                fileToSave = new File(fileToSave + ".pdf");
//            }
//            try {
//                Document document = new Document();
//                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
//                document.open();
//
//                // Add title
//                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
//                Paragraph title = new Paragraph("Employee List", titleFont);
//                title.setAlignment(Element.ALIGN_CENTER);
//                title.setSpacingAfter(20);
//                document.add(title);
//
//                // Create table with headers
//                PdfPTable pdfTable = new PdfPTable(employeeTable.getColumnCount());
//                pdfTable.setWidthPercentage(100);
//                pdfTable.setSpacingBefore(10f);
//                pdfTable.setSpacingAfter(10f);
//
//                // Table header font
//                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
//                BaseColor headerBackgroundColor = BaseColor.GRAY;
//
//                for (int i = 0; i < employeeTable.getColumnCount(); i++) {
//                    PdfPCell headerCell = new PdfPCell(new Phrase(employeeTable.getColumnName(i), headerFont));
//                    headerCell.setBackgroundColor(headerBackgroundColor);
//                    headerCell.setPadding(5);
//                    pdfTable.addCell(headerCell);
//                }
//
//                // Table body font
//                Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
//
//                for (int rows = 0; rows < employeeTable.getRowCount(); rows++) {
//                    for (int cols = 0; cols < employeeTable.getColumnCount(); cols++) {
//                        PdfPCell bodyCell = new PdfPCell(new Phrase(employeeTable.getModel().getValueAt(rows, cols).toString(), bodyFont));
//                        bodyCell.setPadding(5);
//                        pdfTable.addCell(bodyCell);
//                    }
//                }
//
//                document.add(pdfTable);
//
//                // Add footer
//                Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.GRAY);
//                String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//                Paragraph footer = new Paragraph("Generated on: " + currentDate, footerFont);
//                footer.setAlignment(Element.ALIGN_RIGHT);
//                footer.setSpacingBefore(20);
//                document.add(footer);
//
//                document.close();
//                JOptionPane.showMessageDialog(this, "Data exported to PDF successfully");
//            } catch (DocumentException | java.io.IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Error exporting to PDF: " + e.getMessage());
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new EmployeeForm();
//    }
//}

/*** display employees in new form ***/
package gui;

import dao.EmployeeDAO;
import entities.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EmployeeForm extends JFrame {
    private JTextField nameField;
    private JTextField roleField;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private EmployeeDAO employeeDAO;

    public EmployeeForm() {
        employeeDAO = new EmployeeDAO();

        setTitle("Manage Employees");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Role:"));
        roleField = new JTextField();
        formPanel.add(roleField);

        JPanel buttonPanel = new JPanel();

        JButton saveButton = new JButton("Save");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton getButton = new JButton("Get All");
        JButton exportButton = new JButton("Export to PDF");
        JButton getById = new JButton("Get Employee by Id");

        buttonPanel.add(saveButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(getButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(getById);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // JTable for displaying employee data
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Role"}, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        saveButton.addActionListener(e -> saveEmployee());
        updateButton.addActionListener(e -> updateEmployee());
        deleteButton.addActionListener(e -> deleteEmployee());
        getButton.addActionListener(e -> getAllEmployees());
        exportButton.addActionListener(e -> exportToPDF());
        getById.addActionListener(e -> getEmployeeById());

        setVisible(true);
    }

    private void saveEmployee() {
        try {
            String name = nameField.getText();
            String role = roleField.getText();

            Employee employee = new Employee();
            employee.setName(name);
            employee.setRole(role);

            employeeDAO.saveEmployee(employee);
            JOptionPane.showMessageDialog(this, "Employee saved successfully");
            getAllEmployees(); // Refresh table data
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving employee: " + e.getMessage());
        }
    }

    private void updateEmployee() {
        try {
            // Implement update logic using EmployeeDAO
            JOptionPane.showMessageDialog(this, "Update button clicked");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating employee: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        try {
            // Implement delete logic using EmployeeDAO
            JOptionPane.showMessageDialog(this, "Delete button clicked");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting employee: " + e.getMessage());
        }
    }

    private void getAllEmployees() {
        try {
            List<Employee> employees = employeeDAO.getAllEmployees();
            tableModel.setRowCount(0); // Clear existing data
            if (employees != null) {
                for (Employee employee : employees) {
                    tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getRole()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving employees: " + e.getMessage());
        }
    }

    private void exportToPDF() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".pdf")) {
                fileToSave = new File(fileToSave + ".pdf");
            }
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
                document.open();

                // Add title
                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
                Paragraph title = new Paragraph("Employee List", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(20);
                document.add(title);

                // Create table with headers
                PdfPTable pdfTable = new PdfPTable(employeeTable.getColumnCount());
                pdfTable.setWidthPercentage(100);
                pdfTable.setSpacingBefore(10f);
                pdfTable.setSpacingAfter(10f);

                // Load the font that supports Arabic
                BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font headerFont = new Font(baseFont, 12, Font.BOLD, BaseColor.WHITE);
                BaseColor headerBackgroundColor = BaseColor.GRAY;

                // Add table headers
                for (int i = 0; i < employeeTable.getColumnCount(); i++) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(employeeTable.getColumnName(i), headerFont));
                    headerCell.setBackgroundColor(headerBackgroundColor);
                    headerCell.setPadding(5);
                    pdfTable.addCell(headerCell);
                }

                // Table body font
                Font bodyFont = new Font(baseFont, 10);

                // Add table data
                for (int rows = 0; rows < employeeTable.getRowCount(); rows++) {
                    for (int cols = 0; cols < employeeTable.getColumnCount(); cols++) {
                        Object cellValue = employeeTable.getModel().getValueAt(rows, cols);
                        PdfPCell bodyCell = new PdfPCell(new Phrase(cellValue != null ? cellValue.toString() : "", bodyFont));
                        bodyCell.setPadding(5);
                        pdfTable.addCell(bodyCell);
                    }
                }

                // Check if the table is empty
                if (employeeTable.getRowCount() == 0) {
                    System.out.println("Employee table is empty.");
                    JOptionPane.showMessageDialog(this, "Employee table is empty. No data to export.");
                    document.close();
                    return;
                }

                document.add(pdfTable);

                // Add footer
                Font footerFont = new Font(baseFont, 10, Font.NORMAL, BaseColor.GRAY);
                String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                Paragraph footer = new Paragraph("Generated on: " + currentDate, footerFont);
                footer.setAlignment(Element.ALIGN_RIGHT);
                footer.setSpacingBefore(20);
                document.add(footer);

                document.close();
                JOptionPane.showMessageDialog(this, "Data exported to PDF successfully");
            } catch (DocumentException | java.io.IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error exporting to PDF: " + e.getMessage());
            }
        }
    }

    private void displayAllEmployeesInNewForm() {
        JFrame allEmployeesFrame = new JFrame("All Employees");
        allEmployeesFrame.setSize(800, 600);
        allEmployeesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        allEmployeesFrame.setLocationRelativeTo(null);

        DefaultTableModel allEmployeesTableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Role"}, 0);
        JTable allEmployeesTable = new JTable(allEmployeesTableModel);
        JScrollPane scrollPane = new JScrollPane(allEmployeesTable);
        allEmployeesFrame.add(scrollPane, BorderLayout.CENTER);

        try {
            List<Employee> employees = employeeDAO.getAllEmployees();
            allEmployeesTableModel.setRowCount(0); // Clear existing data
            if (employees != null) {
                for (Employee employee : employees) {
                    allEmployeesTableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getRole()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving employees: " + e.getMessage());
        }

        allEmployeesFrame.setVisible(true);
    }

    private void getEmployeeById() {
        try {
            String id = JOptionPane.showInputDialog("Enter employee ID:");
            if (id != null && !id.trim().isEmpty()) {
                int employeeId = Integer.parseInt(id.trim());
                Employee employee = employeeDAO.getEmployeeById(employeeId);
                if (employee != null) {
                    tableModel.setRowCount(0); // Clear existing data
                    tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getRole()});
                } else {
                    JOptionPane.showMessageDialog(this, "No employee found with ID: " + employeeId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving employee: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeForm());
    }
}

