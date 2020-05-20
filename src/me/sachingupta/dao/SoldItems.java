package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;

@Data
public class SoldItems {
    private SimpleStringProperty sn;
    private SimpleStringProperty pName;
    private SimpleStringProperty batchNo;
    private SimpleStringProperty eDate;
    private SimpleFloatProperty gst;
    private SimpleIntegerProperty qty;
    private SimpleFloatProperty amt;
    private SimpleFloatProperty mrp;

    public SoldItems() {}

    public SoldItems(String sn, String pName, String batchNo, String eDate, Float gst, Integer qty, Float amt, Float mrp) {
        this.sn = new SimpleStringProperty(sn);
        this.pName = new SimpleStringProperty(pName);
        this.batchNo = new SimpleStringProperty(batchNo);
        this.eDate = new SimpleStringProperty(eDate);
        this.gst = new SimpleFloatProperty(gst);
        this.qty = new SimpleIntegerProperty(qty);
        this.amt = new SimpleFloatProperty(amt);
        this.mrp = new SimpleFloatProperty(mrp);
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

    public String getpName() {
        return pName.get();
    }

    public SimpleStringProperty pNameProperty() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName.set(pName);
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

    public String geteDate() {
        return eDate.get();
    }

    public SimpleStringProperty eDateProperty() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate.set(eDate);
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

    public int getQty() {
        return qty.get();
    }

    public SimpleIntegerProperty qtyProperty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty.set(qty);
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
