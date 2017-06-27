package me.inventosachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
public class Sale {
    private SimpleStringProperty invoiceno;
    private SimpleStringProperty customername;
    private SimpleStringProperty customerid;
    private SimpleStringProperty quantity;
    private SimpleStringProperty noofitems;
    private SimpleStringProperty amt;
    private SimpleStringProperty paymethod;

    public Sale() {
        this("","","","","","","");
    }

    public Sale(String invoiceno, String customername, String customerid, String quantity, String noofitems, String amt, String paymethod) {
        this.invoiceno = new SimpleStringProperty(invoiceno);
        this.customername = new SimpleStringProperty(customername);
        this.customerid = new SimpleStringProperty(customerid);
        this.quantity = new SimpleStringProperty(quantity);
        this.noofitems = new SimpleStringProperty(noofitems);
        this.amt = new SimpleStringProperty(amt);
        this.paymethod = new SimpleStringProperty(paymethod);
    }

    public String getInvoiceno() {
        return invoiceno.get();
    }

    public SimpleStringProperty invoicenoProperty() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno.set(invoiceno);
    }

    public String getCustomername() {
        return customername.get();
    }

    public SimpleStringProperty customernameProperty() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername.set(customername);
    }

    public String getCustomerid() {
        return customerid.get();
    }

    public SimpleStringProperty customeridProperty() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid.set(customerid);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getNoofitems() {
        return noofitems.get();
    }

    public SimpleStringProperty noofitemsProperty() {
        return noofitems;
    }

    public void setNoofitems(String noofitems) {
        this.noofitems.set(noofitems);
    }

    public String getAmt() {
        return amt.get();
    }

    public SimpleStringProperty amtProperty() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt.set(amt);
    }

    public String getPaymethod() {
        return paymethod.get();
    }

    public SimpleStringProperty paymethodProperty() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod.set(paymethod);
    }
}
