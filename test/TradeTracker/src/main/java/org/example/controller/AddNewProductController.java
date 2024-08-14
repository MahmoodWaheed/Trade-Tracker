package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.model.Product;

public class AddNewProductController {

    @FXML
    private ComboBox<String> categoryField;

    @FXML
    private TextField countField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private Button saveButton;

    @FXML
    void handelSaveButton(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        int price = Integer.parseInt(priceField.getText());
        int count = Integer.parseInt(countField.getText());
        String name = nameField.getText();
        String category = categoryField.getValue();

//        if ()
    }

    @FXML
    private void initialize(){
        ObservableList<String> items = FXCollections.observableArrayList(
                "1", "2","3"
        );
        categoryField.setItems(items);

        // Set an initial selection (optional)
        categoryField.setValue("1");
    }

}

