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
import org.example.model.Person;
import org.example.model.Product;
import org.example.service.PersonService;

public class AddPersonController {

    @FXML
    private AnchorPane addPersonAnchorPane;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField numberOfPurchaseField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button saveButton;

    @FXML
    private ComboBox<String> typeField;

    PersonService personService = new PersonService();

    @FXML
    void handelSaveButton(ActionEvent event) throws Exception {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        int numberOfPurchase = Integer.parseInt(numberOfPurchaseField.getText());
        String type = typeField.getValue();


        if(personService.getPersonById(id)!=null){
            Person person = new Person(id,name,type,address,phone,email,numberOfPurchase);
            personService.updatePerson(person);
            loadContent("PersonDashboard.fxml");
        }else {

            Person person = new Person(name,type,address,phone,email,numberOfPurchase);

            personService.savePerson(person);
            loadContent("AddPerson.fxml");
        }
    }
    @FXML
    private void initialize(){
        int id =personService.lastId()+1;
        idField.setDisable(true);
        idField.setText(String.valueOf(id));

        ObservableList<String> items = FXCollections.observableArrayList(
                "Customer", "Supplier"
        );
        typeField.setItems(items);

        // Set an initial selection (optional)
        typeField.setValue("Customer");
    }
    public void initializeData(Person person) {

        idField.setText(String.valueOf(person.getPersonId()));
        idField.setDisable(true);
        nameField.setText(person.getPersonName());
        phoneField.setText(person.getPhoneNumber());
        emailField.setText(person.getEmail());
        numberOfPurchaseField.setText(String.valueOf((int)(person.getNumberOfPurchase())));
        typeField.setValue(person.getType());
        addressField.setText(person.getAddress());

    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(addPersonAnchorPane.widthProperty());
        content.prefHeightProperty().bind(addPersonAnchorPane.heightProperty());

        addPersonAnchorPane.getChildren().setAll(content);
    }

}
