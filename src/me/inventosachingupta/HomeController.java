package me.inventosachingupta;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import me.inventosachingupta.dao.Employee;
import me.inventosachingupta.dao.Patient;
import me.inventosachingupta.dao.Products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by InventoSachin on 22-06-2017.
 */
public class HomeController {



    int quant;
    ObservableList<Employee> employeeTableData = FXCollections.observableArrayList();
    ObservableList<Patient> patientTableData = FXCollections.observableArrayList();
    ObservableList<Products> productTableData = FXCollections.observableArrayList();
    Connection connection;
    {
        connection = DataBase.getConnection();
    }



    @FXML private StackPane dData;
    @FXML private Pane vSalePane,veEmployeePane,vProductPane,vPatientPane,salePane,iPatient,iEmployee,iMedicine,eMedicineUpdate,eMedicineDelete,eEmployeeUpdate,eEmployeeDelete;
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableView<Patient> patientTable;

    @FXML private ComboBox<String> apSex;
    @FXML private TableColumn<Employee,String> etid,etname,etcontact,etjobtitle,etemail,etdepartment,etshift,ettype,etaddress,etsdate,etedate;
    @FXML private TableColumn<Patient,String> ptid,ptname,ptdob,ptage,ptdoc,ptgender,ptdiagnosis;

    public void initialize(){
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

            employeeTable.setItems(employeeTableData);
            patientTable.setItems(patientTableData);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setColumnTypes();
    }

    public void setColumnTypes(){
        ptid.setCellValueFactory(new PropertyValueFactory<Patient, String>("id"));
        ptname.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        ptdob.setCellValueFactory(new PropertyValueFactory<Patient,String>("dob"));
        ptage.setCellValueFactory(new PropertyValueFactory<Patient,String>("age"));
        ptdoc.setCellValueFactory(new PropertyValueFactory<Patient,String>("doctor_name"));
        ptgender.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
        ptdiagnosis.setCellValueFactory(new PropertyValueFactory<Patient,String>("diagnosis"));

        etid.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
        etname.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        etcontact.setCellValueFactory(new PropertyValueFactory<Employee, String>("contact"));
        etdepartment.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
        etaddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        etsdate.setCellValueFactory(new PropertyValueFactory<Employee, String>("start_date"));
        etedate.setCellValueFactory(new PropertyValueFactory<Employee, String>("end_date"));
        ettype.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));
        etshift.setCellValueFactory(new PropertyValueFactory<Employee, String>("shift"));
        etjobtitle.setCellValueFactory(new PropertyValueFactory<Employee, String>("job_title"));
        etemail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));

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
    @FXML public void exit(){
        System.exit(0);
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
            topNode.setVisible(false);
            newTopNode.toFront();
            newTopNode.setVisible(true);

        });
        slide.play();
    }

}
