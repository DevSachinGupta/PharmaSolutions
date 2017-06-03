package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    int quant;
    Connection connection;

    {
        connection = DataBase.getConnection();
    }

    /**
     * FXML Elements
     */
    @FXML private TextField userID;
    @FXML private PasswordField userPass;
    @FXML private StackPane dData;
    @FXML private Pane vSalePane,veEmployeePane,vProductPane,vPatientPane,salePane;
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
            errorLogin.setText("Enter Correct Values");
            errorLogin.setId("actiontarget");
        }
        else {
            while(rs.next()) {
                if(eid.equals(rs.getString("emp_id")) && password.equalsIgnoreCase(rs.getString("password"))) {
                    root = FXMLLoader.load(getClass().getResource("home.fxml"));
                    Scene scene = new Scene(root);
                    s.setResizable(true);
                    s.setTitle("Home");
                    s.setScene(scene);
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


    @FXML public  void createSale(){

    }

    @FXML public void addEmployee(){

    }
    @FXML public void updateEmployee(){

    }

    @FXML public void addPatient(){

    }
    @FXML public void updatePaitent(){

    }

    @FXML public void addMedicine(){

    }
    @FXML public void updateMedicine(){

    }

    @FXML
    public void exit(){
        System.exit(0);
    }

    public void searchMedicine(){

    }

    /**
     * MenuItem Functions
     */
    @FXML public void viewSaleAction(){
        changeTop(vSalePane);
    }
    @FXML public void viewPatientAction(){
        changeTop(vPatientPane);
    }
    @FXML public void viewEmployeeAction(){
        changeTop(veEmployeePane);
    }
    @FXML public void viewProductAction(){
        changeTop(vProductPane);
    }
    @FXML public void createSaleAction(){
        changeTop(salePane);
    }
    @FXML public void aboutMenuAcion(){

    }
    /**
     *Used to change the nodes of the stackpane using
     * @param node
     */
    private void changeTop(Node node) {
        ObservableList<Node> childs = dData.getChildren();

        Node topNode = childs.get(childs.size()-1);
        Node newTopNode = node;

        double width = dData.getWidth();
        KeyFrame start = new KeyFrame(Duration.ZERO,
                new KeyValue(newTopNode.translateXProperty(), width),
                new KeyValue(topNode.translateXProperty(), 0));
        KeyFrame end = new KeyFrame(Duration.seconds(2),
                new KeyValue(newTopNode.translateXProperty(), 0),
                new KeyValue(topNode.translateXProperty(), -width));
        Timeline slide = new Timeline(start, end);
        slide.setOnFinished(e -> {
            topNode.toBack();
            newTopNode.toFront();
            newTopNode.setVisible(true);
            topNode.setVisible(false);

        });
        slide.play();
    }
}
