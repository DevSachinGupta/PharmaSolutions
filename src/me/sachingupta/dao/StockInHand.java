package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockInHand {

    private SimpleStringProperty itemName;
    private SimpleStringProperty batchNo;
    private SimpleIntegerProperty quantity;
    private SimpleFloatProperty mrp;
    private SimpleStringProperty expiryDate;

    public StockInHand() {}

    public StockInHand(SimpleStringProperty itemName, SimpleStringProperty batchNo, SimpleIntegerProperty quantity, SimpleFloatProperty mrp, SimpleStringProperty expiryDate) {
        this.itemName = itemName;
        this.batchNo = batchNo;
        this.quantity = quantity;
        this.mrp = mrp;
        this.expiryDate = expiryDate;
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getBatchNo() {
        return batchNo.get();
    }

    public SimpleStringProperty batchNoProperty() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo.set(batchNo);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public float getMrp() {
        return mrp.get();
    }

    public SimpleFloatProperty mrpProperty() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp.set(mrp);
    }

    public String getExpiryDate() {
        return expiryDate.get();
    }

    public SimpleStringProperty expiryDateProperty() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate.set(expiryDate);
    }
}
