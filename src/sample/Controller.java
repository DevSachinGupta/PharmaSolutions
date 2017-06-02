package sample;

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
    @FXML
    public void exit(){
        System.exit(0);
    }


//    private static final SQLiteDataSource sqLiteDataSource;

    /**
     * Helper Functions
     */

//    static {
//        sqLiteDataSource=new SQLiteDataSource();
//        sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
//    }

    public void viewSaleAction(){
        changeTop(vSalePane);
    }
    public void viewPatientAction(){
        changeTop(vPatientPane);
    }
    public void viewEmployeeAction(){
        changeTop(veEmployeePane);
    }
    public void viewProductAction(){
        changeTop(vProductPane);
    }
    public void createSaleAction(){
        changeTop(salePane);
    }

    /**
     *
     * @param node
     */
    private void changeTop(Node node) {
        ObservableList<Node> childs = dData.getChildren();

            Node topNode = childs.get(childs.size()-1);
            Node newTopNode = node;

            topNode.setVisible(false);
            topNode.toBack();

            newTopNode.setVisible(true);
            newTopNode.toFront();
    }
}
