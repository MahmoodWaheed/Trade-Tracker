package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.Employee;
import org.example.service.EmployeeService;


import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class ShowEmployeesController {
    @FXML
    private AnchorPane showEmployeeAnchorPane;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML
    private TextField nameToSearch;
    @FXML
    private TableView<Employee> tableView;
    @FXML private TableColumn<Employee, Integer> employeeId;
    @FXML private TableColumn<Employee, String> employeeName;
    @FXML private TableColumn<Employee, String> department;
    @FXML private TableColumn<Employee, String> title;
    @FXML private TableColumn<Employee, Integer> salary;
    @FXML private TableColumn<Employee, String> gender;
    @FXML private TableColumn<Employee, Date> hireDate;
    @FXML private TableColumn<Employee, Date> birthDate;
    @FXML private TableColumn<Employee, String> emailAddress;
    @FXML private TableColumn<Employee, String> phoneNumber;
    @FXML private TableColumn<Employee, String> address;

    private EmployeeService employeeService = new EmployeeService();

    public void HandelSearchByName (){
        updateButton.setDisable(true);
        deleteButton.setDisable(true);
        tableView.getSelectionModel().clearSelection();
        ObservableList<Employee> list1 = employeeService.getAllEmployeesByName(nameToSearch.getText());
        tableView.setItems(list1);
    }


    public void showButton(MouseEvent event){
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            updateButton.setDisable(false);
            deleteButton.setDisable(false);
        }
        else {
            updateButton.setDisable(true);
            deleteButton.setDisable(true);
        }
    }

    public void handelDeleteButton(ActionEvent actionEvent) {
        Employee employee = tableView.getSelectionModel().getSelectedItem();
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete An Employee");
        alert.setHeaderText("you are about to delete "+employee.getEmployeeName());
        alert.setContentText("Are You Sure That You Want To Do That ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            employeeService.deleteEmployee(employee);
            initialize();
        }
    }
    public void updateEmployee(ActionEvent actionEvent) throws Exception {

        Employee employee1 = tableView.getSelectionModel().getSelectedItem();
        loadContent("AddEmployee.fxml",employee1);

    }

    private void loadContent(String fxmlFile,Employee employee) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(showEmployeeAnchorPane.widthProperty());
        content.prefHeightProperty().bind(showEmployeeAnchorPane.heightProperty());

        showEmployeeAnchorPane.getChildren().setAll(content);

        AddEmployeeController addEmployeeController = loader.getController();
        addEmployeeController.intializeData(employee);
    }




    @FXML
    private void initialize() {

//        System.out.println("UpdateEmployeeController initialized");
        updateButton.setDisable(true);
        deleteButton.setDisable(true);


        employeeId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeId"));
        employeeName.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
        department.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        title.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("salary"));
        gender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        hireDate.setCellValueFactory(new PropertyValueFactory<Employee, Date>("hireDate"));
        birthDate.setCellValueFactory(new PropertyValueFactory<Employee, Date>("birthDate"));
        emailAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("emailAddress"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));

        List<Employee> list1 = employeeService.getAllEmployee();
        ObservableList<Employee> list = FXCollections.observableArrayList(list1);

        tableView.setItems(list);

    }
}
