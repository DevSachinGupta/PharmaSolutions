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
import me.inventosachingupta.tableViewHelperClasses.Products;
import me.inventosachingupta.tableViewHelperClasses.Employee;
import me.inventosachingupta.tableViewHelperClasses.Patient;

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
    ObservableList<Employee> employeeTableData = FXCollections.observableArrayList();
    ObservableList<Patient> patientTableData = FXCollections.observableArrayList();
    ObservableList<Products> productTableData = FXCollections.observableArrayList();
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
    @FXML private Pane vSalePane,veEmployeePane,vProductPane,vPatientPane,salePane,iPatient,iEmployee,iMedicine,eMedicineUpdate,eMedicineDelete,eEmployeeUpdate,eEmployeeDelete;
    @FXML private Label errorLogin;
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableView<Patient> patientTable;

    public Controller() {
        try {
            ResultSet rs=connection.createStatement().executeQuery("Select emp_id,emp_name,emp_phone,emp_email,emp_job_title,emp_department,emp_shift,emp_type,emp_address,emp_start_date,emp_end_date  from employeedata");
            while (rs.next()){
                Employee row=new Employee(rs.getString(1),rs.getString(2),String.valueOf(rs.getLong(3)),rs.getString(4)
                        ,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                employeeTableData.add(row);
            }

            rs=connection.createStatement().executeQuery("Select * from PatientDetails");
            while(rs.next()){
                Patient pat=new Patient(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getInt(4)),rs.getString(5),rs.getString(6),rs.getString(7));
                patientTableData.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML public void initialize() {

        System.out.print(employeeTableData+"\n\n"+patientTableData);
        //employeeTable.setItems(employeeTableData);
        //patientTable.setItems(patientTableData);
    }

    private void reteriveDataToObjects(){
        if(veEmployeePane.isVisible()){
            //ResultSet rs=DataBase.selectTableData("select ");
        }
        if(vPatientPane.isVisible()){

        }
        if(vProductPane.isVisible()){

        }
        if(vSalePane.isVisible()){

        }
    }

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

    public void searchData(){

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
    @FXML public void insertEmployeeMenuAcion(){changeTop(iEmployee);}
    @FXML public void insertMedicineMenuAcion(){changeTop(iMedicine);}
    @FXML public void insertPatientMenuAcion(){changeTop(iPatient);}
    @FXML public void updateEmployeeMenuAcion(){changeTop(eEmployeeUpdate);}
    @FXML public void updateMedicineMenuAcion(){changeTop(eMedicineUpdate);}
    @FXML public void deleteEmployeeMenuAcion(){changeTop(eEmployeeDelete);}
    @FXML public void deleteMedicineMenuAcion(){changeTop(eMedicineDelete);}

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
