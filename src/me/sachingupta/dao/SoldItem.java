package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by InventoSachin on 22-06-2017.
 */
@Entity
public class SoldItem {
    @Id
    @Column(name="invoice_no")
    private String invoiceno;
    @Column(name="serial_no")
    private String sn;
    @Column
    private String iname;
    @Column
    private String icode;
    @Column
    private String formulation;//molecule name///generic name
    @Column(name="batch_no")
    private String batchno;
    @Column(name="expiary_date")
    private String edate;
    @Column(name="quantity")
    private float quant;
    @Column(name="amount")
    private float amt;
    @Column
    private float mrp;

    public SoldItem(){
        this("","","","","","","",0F,0.0F,0.0F);
    }

    public SoldItem(String invoiceno, String sn, String iname, String icode, String formulation, String batchno, String edate, float quant, float amt, float mrp) {
        this.invoiceno = invoiceno;
        this.sn = sn;
        this.iname = iname;
        this.icode = icode;
        this.formulation = formulation;
        this.batchno = batchno;
        this.edate = edate;
        this.quant = quant;
        this.amt = amt;
        this.mrp = mrp;
    }

    public SoldItem(String sn, String iname, String icode, String formulation, String batchno, String edate, float quant, float amt, float mrp) {
        this.sn = sn;
        this.iname = iname;
        this.icode = icode;
        this.formulation = formulation;
        this.batchno = batchno;
        this.edate = edate;
        this.quant = quant;
        this.amt = amt;
        this.mrp = mrp;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public float getQuant() {
        return quant;
    }

    public void setQuant(float quant) {
        this.quant = quant;
    }

    public float getAmt() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt = amt;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }
}
