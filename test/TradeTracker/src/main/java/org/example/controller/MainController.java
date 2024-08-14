package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentPlaceholder;


    @FXML
    public void initialize() throws Exception {
//        loadContent("EmployeeDashboard.fxml");
    }

    @FXML
    private void handelEmployeeButtonInDashboard() throws Exception {
        loadContent("EmployeeDashboard.fxml");
    }

    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(contentPlaceholder.widthProperty());
        content.prefHeightProperty().bind(contentPlaceholder.heightProperty());

        contentPlaceholder.getChildren().setAll(content);
    }

    public void handelProductManageButtonInDashboard(ActionEvent actionEvent) throws Exception {
        loadContent("ProductManagementDashboard.fxml");
    }
}
