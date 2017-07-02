package me.inventosachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
public class Products {

    private SimpleStringProperty code;
    private SimpleStringProperty name;
    private SimpleStringProperty bname;//brand name
    private SimpleStringProperty genricname;
    private SimpleStringProperty department;//Speciality
    private SimpleStringProperty type;
    private SimpleStringProperty packsize;
    private SimpleStringProperty quant;
    private SimpleStringProperty batch;
    private  SimpleStringProperty edate;

    public Products() {
        this("","","","","","","","","","");
    }

    public Products(String code, String name, String bname, String genricname, String department, String type, String packsize, String quant,String batch,String edate) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.bname = new SimpleStringProperty(bname);
        this.genricname = new SimpleStringProperty(genricname);
        this.department = new SimpleStringProperty(department);
        this.type = new SimpleStringProperty(type);
        this.packsize = new SimpleStringProperty(packsize);
        this.quant = new SimpleStringProperty(quant);
        this.batch = new SimpleStringProperty(batch);
        this.edate = new SimpleStringProperty(edate);
    }

    public String getBatch() {
        return batch.get();
    }

    public SimpleStringProperty batchProperty() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch.set(batch);
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

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getBname() {
        return bname.get();
    }

    public SimpleStringProperty bnameProperty() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname.set(bname);
    }

    public String getGenricname() {
        return genricname.get();
    }

    public SimpleStringProperty genricnameProperty() {
        return genricname;
    }

    public void setGenricname(String genricname) {
        this.genricname.set(genricname);
    }

    public String getDepartment() {
        return department.get();
    }

    public SimpleStringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getPacksize() {
        return packsize.get();
    }

    public SimpleStringProperty packsizeProperty() {
        return packsize;
    }

    public void setPacksize(String packsize) {
        this.packsize.set(packsize);
    }

    public String getQuant() {
        return quant.get();
    }

    public SimpleStringProperty quantProperty() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant.set(quant);
    }
}
