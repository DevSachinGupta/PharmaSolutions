package me.sachingupta.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField userID;
    @FXML private PasswordField userPass;
    @FXML private Label errorLogin;

    public void exitButtonAction(ActionEvent ae) {
        System.exit(0);
    }

    public void clearButtonAction(ActionEvent ae) {
        userID.setText("");
        userPass.setText("");
        errorLogin.setText("");
    }

    public void loginButtonAction(ActionEvent ae) {

        if (userID.getText().equals("sachin") && userPass.getText().equals("sachin")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/pointOfSale.fxml"));
                Stage stage = (Stage) userID.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            errorLogin.setText("Invalid Username/Password.");
        }
    }

}
