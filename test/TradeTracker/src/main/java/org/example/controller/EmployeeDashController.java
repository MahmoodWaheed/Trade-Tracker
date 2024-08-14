package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class EmployeeDashController {
    @FXML
    AnchorPane employeeAnchorPane;

    public void handelAddEmployeeButton (ActionEvent actionEvent) throws Exception {

        loadContent("AddEmployee.fxml");
    }

    public void handelShowEmployeesButton(ActionEvent actionEvent) throws Exception {
        loadContent("ShowEmployees.fxml");
    }

private void loadContent(String fxmlFile) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
    AnchorPane content = loader.load();
    content.prefWidthProperty().bind(employeeAnchorPane.widthProperty());
    content.prefHeightProperty().bind(employeeAnchorPane.heightProperty());

    employeeAnchorPane.getChildren().setAll(content);
}
}
