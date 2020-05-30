package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class GRN {
    private SimpleStringProperty vendorName;
    private SimpleStringProperty invoiceNo;
    private SimpleStringProperty invoiceDate;;
    private SimpleStringProperty grnNo;
    private SimpleStringProperty grnDate;
    private SimpleFloatProperty totalBillAmount;

    public GRN() {
    }

    public GRN(SimpleStringProperty vendorName, SimpleStringProperty invoiceNo, SimpleStringProperty invoiceDate, SimpleStringProperty grnNo, SimpleStringProperty grnDate, SimpleFloatProperty totalBillAmount) {
        this.vendorName = vendorName;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.grnNo = grnNo;
        this.grnDate = grnDate;
        this.totalBillAmount = totalBillAmount;
    }

    public String getVendorName() {
        return vendorName.get();
    }

    public SimpleStringProperty vendorNameProperty() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName.set(vendorName);
    }

    public String getInvoiceNo() {
        return invoiceNo.get();
    }

    public SimpleStringProperty invoiceNoProperty() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo.set(invoiceNo);
    }

    public String getInvoiceDate() {
        return invoiceDate.get();
    }

    public SimpleStringProperty invoiceDateProperty() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate.set(invoiceDate);
    }

    public String getGrnNo() {
        return grnNo.get();
    }

    public SimpleStringProperty grnNoProperty() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo.set(grnNo);
    }

    public String getGrnDate() {
        return grnDate.get();
    }

    public SimpleStringProperty grnDateProperty() {
        return grnDate;
    }

    public void setGrnDate(String grnDate) {
        this.grnDate.set(grnDate);
    }

    public float getTotalBillAmount() {
        return totalBillAmount.get();
    }

    public SimpleFloatProperty totalBillAmountProperty() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(float totalBillAmount) {
        this.totalBillAmount.set(totalBillAmount);
    }
}
