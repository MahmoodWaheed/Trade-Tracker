package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TryController {
    @FXML TextField textField ;
    Parent root;
    Stage stage ;
    Scene scene ;

    public void getSize (Stage stage) throws IOException {
        System.out.println("im here");
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("try.fxml"));
        root=loader.load();
//        scene = new Scene(root);

        if (stage != null) {
            scene = new Scene(root);
            if (scene != null) {
                System.out.println("im now here");
                textField.setText(String.valueOf(scene.widthProperty().get()));
                // Update TextField with initial scene dimensions
//                textField.setText(String.valueOf(scene.getHeight()));

                // Optional: Add listeners to dynamically update dimensions
                scene.widthProperty().addListener((observable, oldValue, newValue) -> {
                    textField.setText(String.valueOf(newValue.doubleValue()));

                });

                scene.heightProperty().addListener((observable, oldValue, newValue) -> {
                    textField.setText(String.valueOf(newValue.doubleValue()));

                });
            }
    }
    }

    @FXML
    private void initialize() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("try.fxml"));
//        root=loader.load();
//        scene = new Scene(root);
//        getSize();




    }


}
