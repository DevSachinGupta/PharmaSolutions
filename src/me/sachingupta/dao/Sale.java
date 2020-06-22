package me.sachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
@Entity
public class Sale {
    @Id
    @Column(name="invoice_no")
    private String invoiceno;
    @Column(name = "customer_name")
    private String customername;
    @Column(name = "customer_id")
    private String customerid;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "noof_items")
    private String noofitems;
    @Column(name = "amount")
    private String amt;
    @Column(name = "payment_method")
    private String paymethod;

    public Sale() {
        this("","","","","","","");
    }

    public Sale(String invoiceno, String customername, String customerid, String quantity, String noofitems, String amt, String paymethod) {
        this.invoiceno = invoiceno;
        this.customername = customername;
        this.customerid = customerid;
        this.quantity = quantity;
        this.noofitems = noofitems;
        this.amt = amt;
        this.paymethod = paymethod;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNoofitems() {
        return noofitems;
    }

    public void setNoofitems(String noofitems) {
        this.noofitems = noofitems;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }
}
