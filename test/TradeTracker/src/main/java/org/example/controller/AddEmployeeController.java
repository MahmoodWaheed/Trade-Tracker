package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.Employee;
import org.example.service.EmployeeService;

import java.sql.Date;

public class AddEmployeeController {
    @FXML
    private AnchorPane addEmployeeAnchorPane;

    @FXML
    private Label result;

    @FXML
    private ComboBox<String> gender;
    @FXML
    private DatePicker birthDate,hireDate;
    @FXML
    private TextField salary,address,department,title,email,employeeId,employeeName,phoneNumber;

    private EmployeeService employeeService = new EmployeeService();
    private Employee employee;
    private Stage stage;
    private Scene scene;
    private Parent root;




    public void add(ActionEvent actionEvent) throws Exception {
        int id = Integer.parseInt(employeeId.getText());
        String name =employeeName.getText();
        String genderValue = gender.getValue();
        Date birth=Date.valueOf(birthDate.getValue());
        Date hire = Date.valueOf(hireDate.getValue());
        String titleValue = title.getText();
        String departmentValue = department.getText();
        int salaryValue = Integer.valueOf(salary.getText());
        String emailValue = email.getText();
        String phoneValue = phoneNumber.getText();
        String addressValue = address.getText();

        if (employeeService.getEmployee(id) != null)
        {
            employee = new Employee(id, name, birth, genderValue, hire, titleValue, departmentValue,salaryValue,emailValue,phoneValue,addressValue);
            employeeService.updateEmployee(employee);

            loadContent("ShowEmployees.fxml");
        }else {
            employee = new Employee(name,birth,genderValue, hire,titleValue,departmentValue,salaryValue,emailValue,phoneValue,addressValue);
            employeeService.saveEmployee(employee);

            loadContent("AddEmployee.fxml");
        }

    }
    @FXML
    private void initialize() {
        System.out.println("AddEmployeeController initialized");

        int id =employeeService.lastId()+1;
        employeeId.setDisable(true);
        employeeId.setText(String.valueOf(id));

        ObservableList<String> items = FXCollections.observableArrayList(
                "Male", "Femal"
        );
        gender.setItems(items);

        // Set an initial selection (optional)
        gender.setValue("Male");

        // Add a listener to handle selection changes (optional)
        gender.setOnAction(event -> {
            String selectedItem = gender.getSelectionModel().getSelectedItem();
            System.out.println("Selected: " + selectedItem);


        });
    }

    public void initializeData(Employee employee) {

        employeeId.setText(String.valueOf(employee.getEmployeeId()));
        employeeId.setDisable(true);
        employeeName.setText(employee.getEmployeeName());
        department.setText(employee.getDepartment());
        salary.setText(String.valueOf((int)(employee.getSalary())));
        title.setText(employee.getTitle());
        hireDate.setValue(employee.getHireDate().toLocalDate());
        birthDate.setValue(employee.getBirthDate().toLocalDate());
        address.setText(employee.getAddress());
        email.setText(employee.getEmailAddress());
        phoneNumber.setText(employee.getPhoneNumber());
        gender.setValue(employee.getGender());

    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(addEmployeeAnchorPane.widthProperty());
        content.prefHeightProperty().bind(addEmployeeAnchorPane.heightProperty());

        addEmployeeAnchorPane.getChildren().setAll(content);
    }
}
