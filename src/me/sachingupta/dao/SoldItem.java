package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by InventoSachin on 22-06-2017.
 */
public class SoldItem {
    private SimpleStringProperty invoiceno;
    private SimpleStringProperty sn;
    private SimpleStringProperty iname;
    private SimpleStringProperty icode;
    private SimpleStringProperty formulation;//molecule name///generic name
    private SimpleStringProperty batchno;
    private SimpleStringProperty edate;
    private SimpleFloatProperty quant;
    private SimpleFloatProperty amt;
    private SimpleFloatProperty mrp;

    public SoldItem(){
        this("","","","","","","",0F,0.0F,0.0F);
    }

    public SoldItem(String sn, String iname, String icode, String formulation, String batchno, String edate, Float quant, Float amt, Float mrp) {
        this.sn= new SimpleStringProperty(sn);
        this.iname = new SimpleStringProperty(iname);
        this.icode = new SimpleStringProperty(icode);
        this.formulation = new SimpleStringProperty(formulation);
        this.batchno = new SimpleStringProperty(batchno);
        this.edate = new SimpleStringProperty(edate);
        this.quant = new SimpleFloatProperty(quant);
        this.amt = new SimpleFloatProperty(amt);
        this.mrp = new SimpleFloatProperty(mrp);
    }

    public SoldItem(String invoiceno, String sn, String iname, String icode, String formulation, String batchno, String edate, Float quant, Float amt, Float mrp) {
        this.invoiceno = new SimpleStringProperty(invoiceno);
        this.sn= new SimpleStringProperty(sn);
        this.iname = new SimpleStringProperty(iname);
        this.icode = new SimpleStringProperty(icode);
        this.formulation = new SimpleStringProperty(formulation);
        this.batchno = new SimpleStringProperty(batchno);
        this.edate = new SimpleStringProperty(edate);
        this.quant = new SimpleFloatProperty(quant);
        this.amt = new SimpleFloatProperty(amt);
        this.mrp = new SimpleFloatProperty(mrp);
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

    public String getSn() {
        return sn.get();
    }

    public SimpleStringProperty snProperty() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn.set(sn);
    }

    public String getIname() {
        return iname.get();
    }

    public SimpleStringProperty inameProperty() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname.set(iname);
    }

    public String getIcode() {
        return icode.get();
    }

    public SimpleStringProperty icodeProperty() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode.set(icode);
    }

    public String getFormulation() {
        return formulation.get();
    }

    public SimpleStringProperty formulationProperty() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation.set(formulation);
    }

    public String getBatchno() {
        return batchno.get();
    }

    public SimpleStringProperty batchnoProperty() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno.set(batchno);
    }

    public String getEdate() {
        return edate.get();
    }

    public SimpleStringProperty edateProperty() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate.set(edate);
    }

    public float getQuant() {
        return quant.get();
    }

    public SimpleFloatProperty quantProperty() {
        return quant;
    }

    public void setQuant(float quant) {
        this.quant.set(quant);
    }

    public float getAmt() {
        return amt.get();
    }

    public SimpleFloatProperty amtProperty() {
        return amt;
    }

    public void setAmt(float amt) {
        this.amt.set(amt);
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
}
