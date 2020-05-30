package me.sachingupta.dao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.Date;

public class POS {
    private SimpleIntegerProperty billId;
    private SimpleStringProperty billDate;
    private SimpleStringProperty customerName;
    private SimpleStringProperty doctorName;
    private ObservableList<SoldItems> soldItems;
    private SimpleLongProperty discountPercentage;
    private SimpleLongProperty taxableAmount;
    private SimpleLongProperty gstAmount;
    private SimpleLongProperty totalAmount;
    private SimpleLongProperty discountAmount;
    private SimpleLongProperty netPayableAmount;
    private SimpleStringProperty paymentMode;

    public POS() {
    }

    public POS(SimpleIntegerProperty billId, SimpleStringProperty billDate, SimpleStringProperty customerName, SimpleStringProperty doctorName, ObservableList<SoldItems> soldItems, SimpleLongProperty discountPercentage, SimpleLongProperty taxableAmount, SimpleLongProperty gstAmount, SimpleLongProperty totalAmount, SimpleLongProperty discountAmount, SimpleLongProperty netPayableAmount, SimpleStringProperty paymentMode) {
        this.billId = billId;
        this.billDate = billDate;
        this.customerName = customerName;
        this.doctorName = doctorName;
        this.soldItems = soldItems;
        this.discountPercentage = discountPercentage;
        this.taxableAmount = taxableAmount;
        this.gstAmount = gstAmount;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.netPayableAmount = netPayableAmount;
        this.paymentMode = paymentMode;
    }

    public int getBillId() {
        return billId.get();
    }

    public SimpleIntegerProperty billIdProperty() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId.set(billId);
    }

    public String getBillDate() {
        return billDate.get();
    }

    public SimpleStringProperty billDateProperty() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate.set(billDate);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public SimpleStringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public String getDoctorName() {
        return doctorName.get();
    }

    public SimpleStringProperty doctorNameProperty() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName.set(doctorName);
    }

    public ObservableList<SoldItems> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(ObservableList<SoldItems> soldItems) {
        this.soldItems = soldItems;
    }

    public long getDiscountPercentage() {
        return discountPercentage.get();
    }

    public SimpleLongProperty discountPercentageProperty() {
        return discountPercentage;
    }

    public void setDiscountPercentage(long discountPercentage) {
        this.discountPercentage.set(discountPercentage);
    }

    public long getTaxableAmount() {
        return taxableAmount.get();
    }

    public SimpleLongProperty taxableAmountProperty() {
        return taxableAmount;
    }

    public void setTaxableAmount(long taxableAmount) {
        this.taxableAmount.set(taxableAmount);
    }

    public long getGstAmount() {
        return gstAmount.get();
    }

    public SimpleLongProperty gstAmountProperty() {
        return gstAmount;
    }

    public void setGstAmount(long gstAmount) {
        this.gstAmount.set(gstAmount);
    }

    public long getTotalAmount() {
        return totalAmount.get();
    }

    public SimpleLongProperty totalAmountProperty() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public long getDiscountAmount() {
        return discountAmount.get();
    }

    public SimpleLongProperty discountAmountProperty() {
        return discountAmount;
    }

    public void setDiscountAmount(long discountAmount) {
        this.discountAmount.set(discountAmount);
    }

    public long getNetPayableAmount() {
        return netPayableAmount.get();
    }

    public SimpleLongProperty netPayableAmountProperty() {
        return netPayableAmount;
    }

    public void setNetPayableAmount(long netPayableAmount) {
        this.netPayableAmount.set(netPayableAmount);
    }

    public String getPaymentMode() {
        return paymentMode.get();
    }

    public SimpleStringProperty paymentModeProperty() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode.set(paymentMode);
    }
}
