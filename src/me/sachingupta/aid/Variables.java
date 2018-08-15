package me.sachingupta.aid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.sachingupta.dao.*;

public class Variables {

    public static ObservableList<Employee> employeeTableData = FXCollections.observableArrayList();
    public static ObservableList<Patient> patientTableData = FXCollections.observableArrayList();
    public static ObservableList<Products> productTableData = FXCollections.observableArrayList();
    public static ObservableList<Sale> saleTableData = FXCollections.observableArrayList();
    public static ObservableList<SoldItem> saleItemsTableData = FXCollections.observableArrayList();
    public static ObservableList<String> autoCompleteProduct = FXCollections.observableArrayList();

}
