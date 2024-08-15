package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;

public class ProductDashController {
    @FXML private AnchorPane productManagementAnchorPane;

    @FXML private TableView<Product> tableView;

    @FXML private TableColumn<Product, String> ProductName;

    @FXML private TableColumn<Product, String> category;

    @FXML private TableColumn<Product, Integer> price;

    @FXML private TableColumn<Product, Integer> productId;

    @FXML private TableColumn<Product, Integer> stockQuantity;

    @FXML private Button deleteButton;

    @FXML private Button detailsButton;

    @FXML private Button editButton;

    @FXML private TextField nameToSearch;

    @FXML private Button searchButton;


    ProductService productService = new ProductService();


    @FXML
    void HandelSearchByName(MouseEvent event) {
        detailsButton.setDisable(true);
        deleteButton.setDisable(true);
        editButton.setDisable(true);

        tableView.getSelectionModel().clearSelection();
        ObservableList<Product> list1 = productService.getAllItemsByName(nameToSearch.getText());
        tableView.setItems(list1);
    }

    @FXML
    void handelAddNewProductButton(ActionEvent event) throws Exception {
        loadContent("AddProduct.fxml");
    }

    @FXML
    void handelDeleteProductButton(ActionEvent event) {
        Product product = tableView.getSelectionModel().getSelectedItem();
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete An Product");
        alert.setHeaderText("you are about to delete "+product.getName());
        alert.setContentText("Are You Sure That You Want To Do That ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.println(product.getId());
            productService.deleteItem(product);
            initialize();
        }
    }

    @FXML
    void handelEditProductButton(ActionEvent event) throws Exception {
        Product product = tableView.getSelectionModel().getSelectedItem();
        loadContent("AddProduct.fxml",product);

    }

    @FXML
    void handelProductDetailsButton(ActionEvent event) {


    }

    @FXML
    void showButton(MouseEvent event) {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            editButton.setDisable(false);
            deleteButton.setDisable(false);
            detailsButton.setDisable(false);
        }
        else {
            editButton.setDisable(true);
            deleteButton.setDisable(true);
            detailsButton.setDisable(true);

        }

    }

    @FXML
    private void initialize(){
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        detailsButton.setDisable(true);

        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        ProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        stockQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));

        List<Product> list1 = productService.getAllItems();
        ObservableList<Product> list = FXCollections.observableArrayList(list1);

        tableView.setItems(list);
    }
    private void loadContent(String fxmlFile, Product product) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(productManagementAnchorPane.widthProperty());
        content.prefHeightProperty().bind(productManagementAnchorPane.heightProperty());

        productManagementAnchorPane.getChildren().setAll(content);

        AddNewProductController addNewProductController =loader.getController();
        addNewProductController.initializeData(product);

    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(productManagementAnchorPane.widthProperty());
        content.prefHeightProperty().bind(productManagementAnchorPane.heightProperty());

        productManagementAnchorPane.getChildren().setAll(content);


    }

}
