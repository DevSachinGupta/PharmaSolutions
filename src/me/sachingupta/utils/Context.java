package me.sachingupta.utils;

import javafx.collections.ObservableList;
import me.sachingupta.dao.POS;
import me.sachingupta.dao.SoldItems;

public class Context {
    private final static Context context = new Context();
    private ObservableList<SoldItems> saleItemsTableData;
    private POS pos;
    private Context(){}
    public static Context getInstance() {
        return context;
    }

    public ObservableList<SoldItems> getSaleItemsTableData() {
        return saleItemsTableData;
    }

    public void setSaleItemsTableData(ObservableList<SoldItems> saleItemsTableData) {
        this.saleItemsTableData = saleItemsTableData;
    }

}
