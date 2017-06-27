package me.inventosachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
public class Products {

    private SimpleStringProperty code;
    private SimpleStringProperty  name;
    private SimpleStringProperty bname;//brand name
    private SimpleStringProperty category;
    private SimpleStringProperty department;
    private SimpleStringProperty type;
    private SimpleStringProperty packsize;
    private SimpleStringProperty quant;

    public Products() {
        this("","","","","","","","");
    }

    public Products(String code, String name, String bname, String category, String department, String type, String packsize, String quant) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.bname = new SimpleStringProperty(bname);
        this.category = new SimpleStringProperty(category);
        this.department = new SimpleStringProperty(department);
        this.type = new SimpleStringProperty(type);
        this.packsize = new SimpleStringProperty(packsize);
        this.quant = new SimpleStringProperty(quant);
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

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
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
