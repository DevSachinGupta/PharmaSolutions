package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    /**
     * Global variables
     */
    String dname="pmsn",duser="root",dpass="root",durl="";
    String username,password,ename,eid;
    int quant;

    /**
     * FXML Elements
     */
    @FXML private TextField userID;
    @FXML private PasswordField userPass;


    /**
     * FXML Button Actions
     */
    @FXML
    public void login(){
        eid=userID.getText();
        password=userPass.getText();



        //System.out.print(eid+" "+password);
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


    /**
     * Helper Functions
     */
}
