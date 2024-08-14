package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.model.Product;

public class ProductDashController {
    @FXML private AnchorPane productManagementAnchorPane;

    @FXML private TableView<Product> tableView;

    @FXML private TableColumn<Product, String> ProductName;

    @FXML private TableColumn<Product, String> category;

    @FXML private TableColumn<Product, Integer> price;

    @FXML private TableColumn<Product, Integer> productId;

    @FXML private TableColumn<Product, Integer> stockQuantity;

    @FXML private Button deleteButton;

    @FXML private TextField nameToSearch;

    @FXML private Button searchButton;

    @FXML private Button updateButton;

    @FXML
    void HandelSearchByName(ActionEvent event) {

    }

    @FXML
    void handelAddNewProductButton(ActionEvent event) throws Exception {
        loadContent("AddNewProduct.fxml");
    }

    @FXML
    void handelDeleteProductButton(ActionEvent event) {

    }

    @FXML
    void handelEditProductButton(ActionEvent event) {

    }

    @FXML
    void handelProductDetailsButton(ActionEvent event) {

    }

    @FXML
    void showButton(MouseEvent event) {

    }

    @FXML
    private void initialize(){
        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        ProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        stockQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(productManagementAnchorPane.widthProperty());
        content.prefHeightProperty().bind(productManagementAnchorPane.heightProperty());

        productManagementAnchorPane.getChildren().setAll(content);
    }

}
