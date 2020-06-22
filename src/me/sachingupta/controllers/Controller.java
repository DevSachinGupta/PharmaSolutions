package me.sachingupta.controllers;

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
import me.sachingupta.Main;
import me.sachingupta.aid.Context;
import me.sachingupta.aid.DataBaseFactory;
import me.sachingupta.dao.Employee;
import me.sachingupta.database.DB;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Controller {

    /**
     * Global variables
     */
    //String dname="pmsn",duser="root",dpass="root",durl="";
    String username,password,ename,eid;

    ObservableList<String> gender = FXCollections.observableArrayList();
    Connection connection = DataBaseFactory.getInstance().getConnection();
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
            DB employeeDB=new DB("Employee", Employee.class);
            eid = userID.getText();
            password = userPass.getText();

            Stage stage = (Stage) userID.getScene().getWindow();
            Parent root;

            /**
             * Code to verify the username and password
             */
            if (eid.equals("") || password.equals("")) {
                errorLogin.setText("Enter Id and Password");
                errorLogin.setId("actiontarget");
            } else {
                // Here I used the criteriaAndOrderBasedRetrieval.
                List<Employee> employee=employeeDB.criteriaAndOrderBasedRetrieval(new SimpleExpression[]{Restrictions.eq("id",eid)},null);
                    if (!employee.isEmpty() && password.equals(employee.get(0).getPass())) {
                        Context.getInstance().setCat("admin");
                        errorLogin.setText("Logged in Successfully");
                        root = FXMLLoader.load(Main.class.getResource("home.fxml"));
                        //System.out.print("1");
                        Scene scene = new Scene(root);
                        //System.out.print("2");
                        stage.setTitle("Home");
                        //System.out.print("3");
                        stage.setScene(scene);
                        //System.out.print("4");
                        stage.show();
                        //System.out.print("5");

                    } else {
                        errorLogin.setId("actiontarget");
                        errorLogin.setText("Invalid UserID / Password");
                    }
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    @FXML
    public void clear() {
        userID.setText("");
        userPass.setText("");
        errorLogin.setText("");
    }

    @FXML public void exit(){
        System.exit(0);
    }
}
