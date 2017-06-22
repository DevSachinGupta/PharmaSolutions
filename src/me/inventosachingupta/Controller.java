package me.inventosachingupta;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import me.inventosachingupta.dao.Products;
import me.inventosachingupta.dao.Employee;
import me.inventosachingupta.dao.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    /**
     * Global variables
     */
    String dname="pmsn",duser="root",dpass="root",durl="";
    String username,password,ename,eid;

    ObservableList<String> gender = FXCollections.observableArrayList();
    Connection connection;
    {
        connection = DataBase.getConnection();
    }

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
    public void login() throws IOException, SQLException {
        eid=userID.getText();
        password=userPass.getText();

        Stage s= (Stage) userID.getScene().getWindow();
        Parent root;

        /**
         * Code to verify the username and password
         */
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT emp_id,password from employeedata");
        if (eid.equals("") || password.equals("")) {
            errorLogin.setText("Enter Id and PasswordS");
            errorLogin.setId("actiontarget");
        }
        else {
            while(rs.next()) {
                if(eid.equals(rs.getString("emp_id")) && password.equalsIgnoreCase(rs.getString("password"))) {
                    root = FXMLLoader.load(Main.class.getResource("home.fxml"));
                    Scene scene = new Scene(root);
                    scene.setRoot(root);
                    s.setResizable(true);
                    s.setTitle("Home");
                    s.setScene(scene);
                   // setColumnTypes();
                    s.show();
                }
                else {
                    errorLogin.setId("actiontarget");
                    errorLogin.setText("Invalid UserID / Password");
                }
            }
        }
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
