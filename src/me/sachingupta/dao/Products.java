package me.sachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
@Entity
public class Products {
    @Id
    @Column(name = "product_code")
    private String code;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_brand")
    private String bname;//brand name
    @Column(name = "product_category")
    private String category;//Category
    @Column(name = "generic_name")
    private String genricname;
    @Column
    private String department;//Speciality
    @Column
    private String type;
    @Column(name = "pack_size")
    private String packsize;
    @Column(name = "quantity")
    private String quant;
    @Column
    private String batch;
    @Column(name = "expiary_date")
    private String edate;
    @Column
    private String mrp;

    public Products() {
        this("","","","","","","","","","","","");
    }

    public Products(String code, String name, String bname,String category,String genricname, String department, String type, String packsize, String quant, String batch, String edate, String mrp) {
        this.code = code;
        this.name = name;
        this.bname = bname;
        this.category=category;
        this.genricname = genricname;
        this.department = department;
        this.type = type;
        this.packsize = packsize;
        this.quant = quant;
        this.batch = batch;
        this.edate = edate;
        this.mrp = mrp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getGenricname() {
        return genricname;
    }

    public void setGenricname(String genricname) {
        this.genricname = genricname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPacksize() {
        return packsize;
    }

    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
