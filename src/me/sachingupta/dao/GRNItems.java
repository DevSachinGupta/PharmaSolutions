package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GRNItems {
    private SimpleStringProperty sno;
    private SimpleStringProperty itemName;
    private SimpleStringProperty batchNo;
    private SimpleStringProperty expiryDate;
    private SimpleStringProperty packSize;
    private SimpleIntegerProperty quantity;
    private SimpleFloatProperty mrp;
    private SimpleFloatProperty purchaseRate;
    private SimpleFloatProperty gst;
    private SimpleFloatProperty gstAmount;
    private SimpleFloatProperty discount;
    private SimpleFloatProperty discountAmount;
    private SimpleFloatProperty amount;

    public GRNItems(){}

    public GRNItems(SimpleStringProperty sno, SimpleStringProperty itemName, SimpleStringProperty batchNo, SimpleStringProperty expiryDate, SimpleStringProperty packSize, SimpleIntegerProperty quantity, SimpleFloatProperty mrp, SimpleFloatProperty purchaseRate, SimpleFloatProperty gst, SimpleFloatProperty gstAmount, SimpleFloatProperty discount, SimpleFloatProperty discountAmount, SimpleFloatProperty amount) {
        this.sno = sno;
        this.itemName = itemName;
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.packSize = packSize;
        this.quantity = quantity;
        this.mrp = mrp;
        this.purchaseRate = purchaseRate;
        this.gst = gst;
        this.gstAmount = gstAmount;
        this.discount = discount;
        this.discountAmount = discountAmount;
        this.amount = amount;
    }

    public String getSno() {
        return sno.get();
    }

    public SimpleStringProperty snoProperty() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno.set(sno);
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

    public String getExpiryDate() {
        return expiryDate.get();
    }

    public SimpleStringProperty expiryDateProperty() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate.set(expiryDate);
    }

    public String getPackSize() {
        return packSize.get();
    }

    public SimpleStringProperty packSizeProperty() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize.set(packSize);
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

    public float getPurchaseRate() {
        return purchaseRate.get();
    }

    public SimpleFloatProperty purchaseRateProperty() {
        return purchaseRate;
    }

    public void setPurchaseRate(float purchaseRate) {
        this.purchaseRate.set(purchaseRate);
    }

    public float getGst() {
        return gst.get();
    }

    public SimpleFloatProperty gstProperty() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst.set(gst);
    }

    public float getGstAmount() {
        return gstAmount.get();
    }

    public SimpleFloatProperty gstAmountProperty() {
        return gstAmount;
    }

    public void setGstAmount(float gstAmount) {
        this.gstAmount.set(gstAmount);
    }

    public float getDiscount() {
        return discount.get();
    }

    public SimpleFloatProperty discountProperty() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount.set(discount);
    }

    public float getDiscountAmount() {
        return discountAmount.get();
    }

    public SimpleFloatProperty discountAmountProperty() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount.set(discountAmount);
    }

    public float getAmount() {
        return amount.get();
    }

    public SimpleFloatProperty amountProperty() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount.set(amount);
    }
}
