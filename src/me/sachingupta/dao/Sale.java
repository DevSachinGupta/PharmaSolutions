package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sale {
    private SimpleStringProperty billNo;
    private SimpleStringProperty customerName;
    private SimpleStringProperty doctorName;
    private SimpleStringProperty date;
    private SimpleStringProperty modeOfPayment;
    private SimpleFloatProperty taxableAmount;;
    private SimpleFloatProperty gstAmount;
    private SimpleFloatProperty totalBillAmount;
    private SimpleFloatProperty discount;
    private SimpleFloatProperty discountAmount;
    private SimpleFloatProperty netPayableAmount;

    public Sale() {
    }

    public Sale(SimpleStringProperty billNo, SimpleStringProperty customerName, SimpleStringProperty doctorName, SimpleStringProperty date, SimpleStringProperty modeOfPayment, SimpleFloatProperty taxableAmount, SimpleFloatProperty gstAmount, SimpleFloatProperty totalBillAmount, SimpleFloatProperty discount, SimpleFloatProperty discountAmount, SimpleFloatProperty netPayableAmount) {
        this.billNo = billNo;
        this.customerName = customerName;
        this.doctorName = doctorName;
        this.date = date;
        this.modeOfPayment = modeOfPayment;
        this.taxableAmount = taxableAmount;
        this.gstAmount = gstAmount;
        this.totalBillAmount = totalBillAmount;
        this.discount = discount;
        this.discountAmount = discountAmount;
        this.netPayableAmount = netPayableAmount;
    }

    public String getBillNo() {
        return billNo.get();
    }

    public SimpleStringProperty billNoProperty() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo.set(billNo);
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getModeOfPayment() {
        return modeOfPayment.get();
    }

    public SimpleStringProperty modeOfPaymentProperty() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment.set(modeOfPayment);
    }

    public float getTaxableAmount() {
        return taxableAmount.get();
    }

    public SimpleFloatProperty taxableAmountProperty() {
        return taxableAmount;
    }

    public void setTaxableAmount(float taxableAmount) {
        this.taxableAmount.set(taxableAmount);
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

    public float getTotalBillAmount() {
        return totalBillAmount.get();
    }

    public SimpleFloatProperty totalBillAmountProperty() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(float totalBillAmount) {
        this.totalBillAmount.set(totalBillAmount);
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

    public float getNetPayableAmount() {
        return netPayableAmount.get();
    }

    public SimpleFloatProperty netPayableAmountProperty() {
        return netPayableAmount;
    }

    public void setNetPayableAmount(float netPayableAmount) {
        this.netPayableAmount.set(netPayableAmount);
    }
}
