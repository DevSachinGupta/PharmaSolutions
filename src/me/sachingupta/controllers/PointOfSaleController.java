package me.sachingupta.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import me.sachingupta.dao.SoldItems;
import me.sachingupta.utils.Context;

public class PointOfSaleController {
    // content.getChildren().setAll(FXMLLoader.load("vista2.fxml"));

    @FXML TableView<SoldItems> posProducts, printSampleProductsList;
    @FXML TableColumn<SoldItems, String> sno, itemName, batchNo, expiryDate;
    @FXML TableColumn<SoldItems, Float> mrp, gstPercent, amount;
    @FXML TableColumn<SoldItems, Integer> qty;
    @FXML TextField customerName, doctorName;

    Context context = Context.getInstance();
    ObservableList<SoldItems> saleItemsTableData = FXCollections.observableArrayList();

    public void initialize() {
        setColumnProperties();
        for(int i = 1; i <= 50; i++) {
            saleItemsTableData.add(new SoldItems(String.valueOf(i), "A very Long Name"+i, "A very Long batch"+i , "DD/09/YYY", Integer.valueOf(i).floatValue(), i, Integer.valueOf(i).floatValue(), Integer.valueOf(i).floatValue()));
        }
        context.setSaleItemsTableData(saleItemsTableData);
        // printSampleProductsList.setItems(saleItemsTableData);
    }
    private void  setColumnProperties() {
        sno.setCellValueFactory(new PropertyValueFactory<SoldItems, String>("sn"));
        itemName.setCellValueFactory(new PropertyValueFactory<SoldItems, String>("pName"));
        batchNo.setCellValueFactory(new PropertyValueFactory<SoldItems, String>("batchNo"));
        expiryDate.setCellValueFactory(new PropertyValueFactory<SoldItems, String>("eDate"));
        mrp.setCellValueFactory(new PropertyValueFactory<SoldItems, Float>("mrp"));
        gstPercent.setCellValueFactory(new PropertyValueFactory<SoldItems, Float>("gst"));
        amount.setCellValueFactory(new PropertyValueFactory<SoldItems, Float>("amt"));
        qty.setCellValueFactory(new PropertyValueFactory<SoldItems, Integer>("qty"));
        posProducts.setItems(saleItemsTableData);
        batchNo.setCellFactory(TextFieldTableCell.forTableColumn());
        qty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

//        sno1.setCellValueFactory(new PropertyValueFactory<>("sn"));
//        itemName1.setCellValueFactory(new PropertyValueFactory<>("pName"));
//        batchNo1.setCellValueFactory(new PropertyValueFactory<>("batchNo"));
//        expiryDate1.setCellValueFactory(new PropertyValueFactory<>("eDate"));
//        mrp1.setCellValueFactory(new PropertyValueFactory<>("mrp"));
//        gstPercent1.setCellValueFactory(new PropertyValueFactory<>("gst"));
//        amount1.setCellValueFactory(new PropertyValueFactory<>("amt"));
//        qty1.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    @FXML private void saveAndPrint(ActionEvent event) {
        saveDetails();
        printDetails(event);
    }

    private void saveDetails() {

    }
    private void printDetails(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("../view/printBills2.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Print Preview");
            stage.show();

        } catch(Exception e) {
            System.out.println("print called");
            e.printStackTrace();
        }

    }

}
