package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.model.Person;
import org.example.model.Product;
import org.example.service.PersonService;

import java.util.List;

public class PersonDashController {

    @FXML
    private AnchorPane PersonDashAnchorPane;

    @FXML
    private Button deleteButton;

    @FXML
    private Button detailsButton;

    @FXML
    private Button editButton;

    @FXML
    private TextField nameToSearch;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<Person, String> email;

    @FXML
    private TableColumn<Person, String> address;

    @FXML
    private TableColumn<Person, Integer> numberOfPurchase;

    @FXML
    private TableColumn<Person, Integer> personId;

    @FXML
    private TableColumn<Person, String> personName;

    @FXML
    private TableColumn<Person, String> phoneNumber;

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> type;

    PersonService personService = new PersonService();


    public void HandelSearchByName() {
        detailsButton.setDisable(true);
        deleteButton.setDisable(true);
        editButton.setDisable(true);

        tableView.getSelectionModel().clearSelection();
        ObservableList<Person> personObservableList = personService.getAllIPersonsByName(nameToSearch.getText());
        tableView.setItems(personObservableList);
    }

    @FXML
    void handelAddNewPersonButton(ActionEvent event) throws Exception {
        loadContent("AddPerson.fxml");
    }

    @FXML
    void handelDeletePersonButton(ActionEvent event) {
        Person person = tableView.getSelectionModel().getSelectedItem();
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete An Product");
        alert.setHeaderText("you are about to delete "+person.getPersonName());
        alert.setContentText("Are You Sure That You Want To Do That ?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.println(personName.getId());
            personService.deletePerson(person);
            initialize();
        }
    }

    @FXML
    void handelEditPersonButton(ActionEvent event) throws Exception {
        Person person = tableView.getSelectionModel().getSelectedItem();
        loadContent("AddPerson.fxml",person);
    }

    @FXML
    void handelPersonDetailsButton(ActionEvent event) {

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

        personId.setCellValueFactory(new PropertyValueFactory<Person, Integer>("personId"));
        personName.setCellValueFactory(new PropertyValueFactory<Person, String>("personName"));
        numberOfPurchase.setCellValueFactory(new PropertyValueFactory<Person, Integer>("numberOfPurchase"));
        type.setCellValueFactory(new PropertyValueFactory<Person, String>("type"));
        email.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));


        List<Person> list1 = personService.getAllPersons();
        ObservableList<Person> list = FXCollections.observableArrayList(list1);

        tableView.setItems(list);
    }
    private void loadContent(String fxmlFile, Person person) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(PersonDashAnchorPane.widthProperty());
        content.prefHeightProperty().bind(PersonDashAnchorPane.heightProperty());

        PersonDashAnchorPane.getChildren().setAll(content);

        AddPersonController addPersonController =loader.getController();
        addPersonController.initializeData(person);

    }
    private void loadContent(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFile));
        AnchorPane content = loader.load();
        content.prefWidthProperty().bind(PersonDashAnchorPane.widthProperty());
        content.prefHeightProperty().bind(PersonDashAnchorPane.heightProperty());

        PersonDashAnchorPane.getChildren().setAll(content);


    }

}
