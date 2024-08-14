package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.model.Employee;
import org.example.model.Product;
import org.example.service.ProductService;

public class AddNewProductController {

    @FXML
    private AnchorPane addProductAnchorPane;

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
    ProductService productService = new ProductService();

    @FXML
    void handelSaveButton(ActionEvent event) throws Exception {
        int id = Integer.parseInt(idField.getText());
        int price = Integer.parseInt(priceField.getText());
        int count = Integer.parseInt(countField.getText());
        String name = nameField.getText();
        String category = categoryField.getValue();
        if(productService.getItemById(id)!=null){
            Product product = new Product(id,name, price, count, category);
            productService.updateItem(product);
            loadContent("ProductManagementDashboard.fxml");
        }else {

            Product product = new Product(name, price, count, category);

            productService.saveItem(product);
            loadContent("AddNewProduct.fxml");
        }


    }

    @FXML
    private void initialize(){
        int id =productService.lastId()+1;
        idField.setDisable(true);
        idField.setText(String.valueOf(id));

        ObservableList<String> items = FXCollections.observableArrayList(
                "1", "2","3"
        );
        categoryField.setItems(items);

        // Set an initial selection (optional)
        categoryField.setValue("1");
    }
    public void initializeData(Product product) {

        idField.setText(String.valueOf(product.getId()));
        idField.setDisable(true);
        nameField.setText(product.getName());
        priceField.setText(String.valueOf(product.getPrice()));
        countField.setText(String.valueOf((int)(product.getCount())));
        categoryField.setValue(product.getCategory());

    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(addProductAnchorPane.widthProperty());
        content.prefHeightProperty().bind(addProductAnchorPane.heightProperty());

        addProductAnchorPane.getChildren().setAll(content);
    }

}

