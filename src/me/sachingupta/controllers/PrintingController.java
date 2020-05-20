package me.sachingupta.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import me.sachingupta.dao.SoldItems;
import me.sachingupta.utils.Context;

import java.net.URL;
import java.util.ResourceBundle;

public class PrintingController implements Initializable {

    @FXML
    GridPane printSample;
    @FXML
    TableView<SoldItems> printSampleProductsList;
    @FXML
    TableColumn<SoldItems, String> sno1, itemName1, batchNo1, expiryDate1;
    @FXML TableColumn<SoldItems, Float> mrp1, gstPercent1, amount1;
    @FXML TableColumn<SoldItems, Integer> qty1;
    @FXML
    Label customerNameLabel, doctorNameLabel, billNoLabel, billDateLabel;

    Context context = Context.getInstance();

    javafx.util.Callback<TableColumn<SoldItems, String>, TableCell<SoldItems, String>> WRAPPING_CELL_FACTORY = new javafx.util.Callback<TableColumn<SoldItems,String>, TableCell<SoldItems,String>>(){
        @Override
        public TableCell<SoldItems, String> call( TableColumn<SoldItems, String> param) {
            final TableCell<SoldItems, String> cell = new TableCell<SoldItems, String>() {
                private Text text;
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item.toString());
                        text.setWrappingWidth(param.getWidth()); // Setting the wrapping width to the Text
                        setGraphic(text);
                    }
                }
            };
            return cell;
        }
    };

    private void initialize() {
        sno1.setCellValueFactory(new PropertyValueFactory<>("sn"));
        itemName1.setCellValueFactory(new PropertyValueFactory<>("pName"));
        batchNo1.setCellValueFactory(new PropertyValueFactory<>("batchNo"));
        expiryDate1.setCellValueFactory(new PropertyValueFactory<>("eDate"));
        mrp1.setCellValueFactory(new PropertyValueFactory<>("mrp"));
        gstPercent1.setCellValueFactory(new PropertyValueFactory<>("gst"));
        amount1.setCellValueFactory(new PropertyValueFactory<>("amt"));
        qty1.setCellValueFactory(new PropertyValueFactory<>("qty"));
        printSampleProductsList.setItems(context.getSaleItemsTableData());

        itemName1.setCellFactory(WRAPPING_CELL_FACTORY);
        batchNo1.setCellFactory(WRAPPING_CELL_FACTORY);
        expiryDate1.setCellFactory(WRAPPING_CELL_FACTORY);

        Printer printer = Printer.getDefaultPrinter();
        PrinterJob job = PrinterJob.createPrinterJob();

        PageLayout pageLayout = null;

        if(printer != null) {
            pageLayout = printer.createPageLayout(Paper.A5, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        }

        if (job != null && job.showPrintDialog(printSample.getScene().getWindow())) {
            boolean success = job.printPage(pageLayout, printSample);
            if (success) {
                job.endJob();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }
}
