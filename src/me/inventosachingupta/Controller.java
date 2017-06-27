package me.inventosachingupta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    /**
     * Global variables
     */
    //String dname="pmsn",duser="root",dpass="root",durl="";
    String username,password,ename,eid;

    ObservableList<String> gender = FXCollections.observableArrayList();
    Connection connection;
    {
        connection = DataBase.getConnection();
    }
    Context context=Context.getInstance();

    /**
     * FXML Elements
     */
    @FXML private TextField userID;
    @FXML private PasswordField userPass;
    @FXML private Label errorLogin;



    /**
     * FXML Button Actions
     */
    @FXML
    public void login()  {
        try {
            eid = userID.getText();
            password = userPass.getText();

            Stage stage = (Stage) userID.getScene().getWindow();
            Parent root;

            /**
             * Code to verify the username and password
             */
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT emp_id,password FROM employeedata");
            if (eid.equals("") || password.equals("")) {
                errorLogin.setText("Enter Id and PasswordS");
                errorLogin.setId("actiontarget");
            } else {
                while (rs.next()) {
                    if (eid.equals(rs.getString("emp_id")) && password.equalsIgnoreCase(rs.getString("password"))) {
                        Context.getInstance().setCat("admin");
                        errorLogin.setText("Logged in Successfully");
                        root = FXMLLoader.load(getClass().getResource("home.fxml"));
                        Scene scene = new Scene(root);
                        stage.setTitle("Home");
                        stage.setScene(scene);
                        stage.show();

                    } else {
                        errorLogin.setId("actiontarget");
                        errorLogin.setText("Invalid UserID / Password");
                    }
                }
            }
        }
        catch (Exception e){}
    }

    @FXML
    public void clear() {
        userID.setText("");
        userPass.setText("");
    }

    @FXML public void exit(){
        System.exit(0);
    }
}
