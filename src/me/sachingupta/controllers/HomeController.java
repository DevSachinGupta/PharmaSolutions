package me.sachingupta.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.sachingupta.Main;
import me.sachingupta.aid.*;
import me.sachingupta.dao.*;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Created by InventoSachin on 22-06-2017.
 */
public class HomeController {

    Context context=Context.getInstance();
    String invoiceNO;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    int sno=1;
    float total_quant = 0 ;
    float total_amt = 0 ;

    private static int invoiceNoConstant = 1;


    Alert error_alert = new Alert(Alert.AlertType.ERROR);
    Alert info_alert = new Alert(Alert.AlertType.INFORMATION);

    ObservableList<Employee> employeeTableData = FXCollections.observableArrayList();
    ObservableList<Patient> patientTableData = FXCollections.observableArrayList();
    ObservableList<Products> productTableData = FXCollections.observableArrayList();
    ObservableList<Sale> saleTableData = FXCollections.observableArrayList();
    ObservableList<SoldItem> saleItemsTableData = FXCollections.observableArrayList();
    ObservableList<String> autoCompleteProduct = FXCollections.observableArrayList();

    Connection connection;
    {
        connection = DataBaseFactory.getInstance().getConnection();
    }
    private String cat;//used for employe category

    Products cuurent_product;

    @FXML private StackPane dData;
    @FXML private Pane vSalePane,veEmployeePane,vProductPane,vPatientPane,salePane,iPatient,iEmployee,iMedicineA,iMedicineE,eMedicineUpdate,eMedicineDelete,eEmployeeUpdate,eEmployeeDelete;

    @FXML private TableView<Employee> employeeTable;
    @FXML private TableView<Patient> patientTable;
    @FXML private TableView<Products> productTable;
    @FXML private TableView<Sale> saleTable;
    @FXML private TableView<SoldItem> saleItemTable;

    @FXML private MenuItem aboutMenu,deleteEmployeeMenuitem,updateEmployeeMenuitem,addEmployeeMenuitem,seprateMenuItem;

    //Table Column Used in different Panels
    @FXML private TableColumn<Employee,String> etid,etname,etcontact,etjobtitle,etemail,etdepartment,etshift,ettype,etaddress,etsdate,etedate;
    @FXML private TableColumn<Patient,String> ptid,ptname,ptdob,ptage,ptdoc,ptgender,ptdiagnosis;
    @FXML private TableColumn<SoldItem,String> ssn,siname,sic,ssf,sbn,sed;
    @FXML private TableColumn<SoldItem,Float> sq,smrp,samt;
    @FXML private TableColumn<Products,String> pdtcode,pdtname,pdtbname,pdtdepartment,pdtpsize,pdtptype,pdtquantity;
    @FXML private TableColumn<Sale,String> sdtino,sdtcid,sdtcname,sdtnoi,sdtquant,sdtamt,sdtmop;

    //Fields from Patient Panel
    @FXML private TextArea apDiagnosis;
    @FXML private ComboBox<String> apSex;
    @FXML private TextField apId,apName,apAge,apdname;
    @FXML private DatePicker apDOB;

    //Fields from Sales Panel
    @FXML private TextField pspname,pspquant,pspcode,pspgname,pspcname,pspbatchid,pspedate,pspcid,psptquant,psptamt;
    @FXML private ToggleGroup g1;
    @FXML private RadioButton rcash,rcard,relectronic;

    //Methods starts here
    public void initialize() {
        error_alert.setHeaderText("There is a error.\n The Error is given below");
        error_alert.setTitle("Error");
        info_alert.setTitle("Information");
        generateInvoiceNo();
        apId.setText(generatePatietId());
        setColumnTypes();
        System.out.println(Context.getInstance().getCat());
        cat=Context.getInstance().getCat();
        if(!cat.equalsIgnoreCase("admin")){
            //seprateMenuItem.setDisable(true);
            seprateMenuItem.setVisible(false);
            updateEmployeeMenuitem.setVisible(false);
            addEmployeeMenuitem.setVisible(false);
            deleteEmployeeMenuitem.setVisible(false);
        }
        try {

            AutoCompletionBinding<String> abc=TextFields.bindAutoCompletion(pspname,autoCompleteProduct);
            abc.setOnAutoCompleted(new EventHandler<AutoCompletionBinding.AutoCompletionEvent<String>>() {
                @Override
                public void handle(AutoCompletionBinding.AutoCompletionEvent<String> event) {
                    String s = event.getCompletion();
                    for(Products products:productTableData){
                        if((products.getName()).equalsIgnoreCase(s)) {
                            pspbatchid.setText(products.getBatch());
                            pspcode.setText(products.getCode());
                            pspgname.setText(products.getGenricname());
                            pspedate.setText(products.getEdate());
                            cuurent_product = products;
                        }
                    }
                    //System.out.println(s+"\n"+cuurent_product);
                }
            });
            abc.setPrefWidth(pspname.getWidth() * 1.5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setColumnTypes(){
        sdtino.setCellValueFactory(new PropertyValueFactory<Sale,String>("invoiceno"));
        sdtcid.setCellValueFactory(new PropertyValueFactory<Sale,String>("customerid"));
        sdtcname.setCellValueFactory(new PropertyValueFactory<Sale,String>("customername"));
        sdtnoi.setCellValueFactory(new PropertyValueFactory<Sale,String>("noofitems"));
        sdtquant.setCellValueFactory(new PropertyValueFactory<Sale,String>("quantity"));
        sdtamt.setCellValueFactory(new PropertyValueFactory<Sale,String>("amt"));
        sdtmop.setCellValueFactory(new PropertyValueFactory<Sale,String>("paymethod"));

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

        pdtcode.setCellValueFactory(new PropertyValueFactory<Products,String>("code"));
        pdtname.setCellValueFactory(new PropertyValueFactory<Products,String>("name"));
        //pdtCategory.setCellValueFactory(new PropertyValueFactory<Products,String>("category"));
        pdtbname.setCellValueFactory(new PropertyValueFactory<Products,String>("bname"));
        pdtdepartment.setCellValueFactory(new PropertyValueFactory<Products,String>("department"));
        pdtpsize.setCellValueFactory(new PropertyValueFactory<Products,String>("packsize"));
        pdtptype.setCellValueFactory(new PropertyValueFactory<Products,String>("type"));
        pdtquantity.setCellValueFactory(new PropertyValueFactory<Products,String>("quant"));

        ssn.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("sn"));
        sic.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("icode"));
        siname.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("iname"));
        ssf.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("formulation"));
        sbn.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("batchno"));
        sq.setCellValueFactory(new PropertyValueFactory<SoldItem,Float>("quant"));
        smrp.setCellValueFactory(new PropertyValueFactory<SoldItem,Float>("mrp"));
        samt.setCellValueFactory(new PropertyValueFactory<SoldItem,Float>("amt"));
        sed.setCellValueFactory(new PropertyValueFactory<SoldItem,String>("edate"));
    }

    private void reteriveDataToObjects(){
        try {
            ResultSet rs;
            if (veEmployeePane.isVisible()) {
                employeeTableData.clear();
                 rs=connection.createStatement().executeQuery("Select emp_id,emp_name,emp_phone,emp_email,emp_job_title,emp_department,emp_shift,emp_type,emp_address,emp_start_date,emp_end_date  from employeedata");
                while (rs.next()){
                    Employee row=new Employee(rs.getString(1),rs.getString(2),String.valueOf(rs.getLong(3)),rs.getString(4)
                            ,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                    employeeTableData.add(row);
                }
            }
            if (vPatientPane.isVisible()) {
                patientTableData.clear();
                rs=connection.createStatement().executeQuery("Select * from PatientDetails");
                while(rs.next()){
                    Patient pat=new Patient(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getInt(4)),rs.getString(5),rs.getString(6),rs.getString(7));
                    patientTableData.add(pat);
                }
            }
            if (vProductPane.isVisible()) {
                rs=connection.createStatement().executeQuery("Select ItemCode,ItemName,BRANDNAME,Category,Department,ItemType,PACKSIZE,Quantity,GENERICNAME,EXPDATE,MRP from ProductsDetails");
                while(rs.next()){
                    Products prod=new Products(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                    productTableData.add(prod);
                }
            }
            if (vSalePane.isVisible()) {
                saleTableData.clear();
                rs=connection.createStatement().executeQuery("Select * from Sale");
                while(rs.next()){
                    Sale pat=new Sale(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getInt(4)),rs.getString(5),rs.getString(6),rs.getString(7));
                    saleTableData.add(pat);
                }
            }
        }catch(Exception ex){}
    }

    @FXML public  void createSale() {
        String paymode =  " ";
        if(rcash.isSelected())
            paymode = "Cash Payment";
        if(rcard.isSelected())
            paymode = "Card Payment";
        if(relectronic.isSelected())
            paymode = "E-Wallet Payment";
        String cid = pspcid.getText();
        String cname = pspcname.getText();
        System.out.println(paymode);
        if(cid.equalsIgnoreCase("") || cname.equalsIgnoreCase("")){
            error_alert.setContentText("Enter The value of either Customer Name or Customer ID.");
            error_alert.showAndWait();
        }
        else {
            ///Sale s = new Sale(invoiceNO,cname,cid,String.valueOf(total_quant),String.valueOf(sno),String.valueOf(total_amt),paymode);
            String sql="insert into Sale values('"+invoiceNO+"','"+cname+"','"+cid+"','"+total_quant+"','"+(sno-1)+"','"+total_amt+"','"+paymode+"');";
            int i = (new SaleDBFactory()).add(sql);
            if(i != -1){
                info_alert.setContentText("Invoice Successful Thanks for shoppiing..");
                info_alert.showAndWait();
                for(SoldItem s:saleItemsTableData){
                    (new SoldItemsDBFactory()).add(s);
                }
            }
            clearNodes(salePane);
            invoiceNoConstant = invoiceNoConstant + 1;
            generateInvoiceNo();
        }
    }
    private void clearNodes(Pane panel){
        for(Node n : panel.getChildren()){
            if(n instanceof TextField)
                ((TextField)n).clear();
            if(n instanceof TableView)
                ((TableView) n).getItems().clear();
        }
    }

    @FXML public void addEmployee(){

    }
    @FXML public void updateEmployee(){

    }
    @FXML public void addPatient(){
        String id = apId.getText();
        String name=apName.getText();
        String dname=apdname.getText();
        String diag=apDiagnosis.getText();
        String sex=apSex.getValue();
        LocalDate ld=apDOB.getValue();
        String dob = String.valueOf(dateTimeFormatter.format(ld));
        int age = AgeCalculator.calculateAge(ld);
        String sql="insert into PatientDetails values('"+id+"','"+name+"','"+dob+"','"+age+"','"+sex+"','"+dname+"','"+diag+"');";
        //int i =
        (new PatientDBFactory()).add(new Patient(id,name,dob,String.valueOf(age),sex,dname,diag));
        //System.out.println(name+" "+age+" "+dname+" "+diag+" "+sex+" "+dob+ " "+i);
    }
    @FXML public void updatePaitent(){

    }
    @FXML public void addMedicine(){

    }
    @FXML public void updateMedicine(){

    }

    @FXML public void addItemButtonAction(){
        float ps= Convert2Int.c2i(cuurent_product.getPacksize());
        float tmrp=Float.parseFloat(cuurent_product.getMrp());
        float tquany=Float.parseFloat(pspquant.getText());
        float tamt=(tmrp/ps)*tquany;
        total_amt = total_amt+tamt;
        total_quant = total_quant+tquany;
        saleItemsTableData.add(new SoldItem(invoiceNO,String.valueOf(sno),cuurent_product.getName(),cuurent_product.getCode(),cuurent_product.getGenricname(),cuurent_product.getBatch(),cuurent_product.getEdate(),tquany,tamt,tmrp));
        sno=sno+1;
        pspname.setText("");
        pspbatchid.setText("");
        pspcode.setText("");
        pspgname.setText("");
        pspedate.setText("");
        pspquant.setText("");
        psptamt.setText(String.valueOf(total_amt));
        psptquant.setText(String.valueOf(total_quant));
    }
    @FXML public void deleteItemButtonAction(){
        int tsn = 1;
        //int in = saleTable.getSelectionModel().getSelectedIndex();
        SoldItem in = saleItemTable.getSelectionModel().getSelectedItem();
        //saleItemTable.getItems().remove(in);
        saleItemsTableData.remove(in);
        //System.out.println(in);
        for(SoldItem si:saleItemsTableData){
            //tsn = tsn+1;
            si.setSn(String.valueOf(tsn));
            tsn = tsn+1;
        }
        sno = tsn;
        total_amt = total_amt - in.getAmt();
        total_quant = total_quant - in.getQuant();
        psptamt.setText(String.valueOf(total_amt));
        psptquant.setText(String.valueOf(total_quant));

    }
    @FXML public void setApAge(){
        LocalDate ld=apDOB.getValue();
        int age = AgeCalculator.calculateAge(ld);
        apAge.setText(String.valueOf(age));
    }
    /**
     * MenuItem Functions
     */
    @FXML public void viewSaleAction(){
        changeTop(vSalePane);
        reteriveDataToObjects();
    }
    @FXML public void viewPatientAction(){
        changeTop(vPatientPane);
        reteriveDataToObjects();
    }
    @FXML public void viewEmployeeAction(){
        changeTop(veEmployeePane);
        reteriveDataToObjects();
    }
    @FXML public void viewProductAction(){
        changeTop(vProductPane);
        reteriveDataToObjects();
    }
    @FXML public void createSaleAction(){
        changeTop(salePane);
    }
    @FXML public void aboutMenuAcion() throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("about.fxml"));
        Stage stage = new Stage();
        stage.setTitle("About");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
    @FXML public void insertEmployeeMenuAcion(){changeTop(iEmployee);}
    @FXML public void insertMedicineMenuAcion(){
        if(cat.equalsIgnoreCase("admin"))
        changeTop(iMedicineA);
        else
            changeTop(iMedicineE);
    }
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

        topNode.toBack();
        topNode.setVisible(false);
        newTopNode.toFront();
        newTopNode.setVisible(true);
    }

    /**
     * Method to generate invoice no
     */
    private void generateInvoiceNo(){
        String invoice = "";
        Calendar d = Calendar.getInstance();
        invoice = String.valueOf(d.get(Calendar.YEAR))+String.valueOf(d.get(Calendar.MONTH))+String.valueOf(d.get(Calendar.DATE))+invoiceNoConstant;
        invoiceNO = invoice;
    }
    private String generatePatietId(){
        String id = "1";
        try{
            ResultSet rs = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("select patient_id FROM PatientDetails");
            while(rs.next())
            id = (rs.getString(1)).substring(3);
            int no = (Integer.parseInt(id))+1;
            int len = id.length() - ((String.valueOf(no))).length();
            id="PAT";
            for(int i=1 ; i<=len ; i++)
                id=id+"0";
            id=id+no;
        }catch (Exception exc){ exc.printStackTrace();}

        return id;
    }
}
