package me.sachingupta.dao;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Products {
    // private long id;
    private SimpleStringProperty itemType;
    private SimpleStringProperty name;
    private SimpleStringProperty strength;
    private SimpleStringProperty genericName;
    private SimpleStringProperty packSize;
    private SimpleStringProperty category;
    private SimpleStringProperty manufacturer;
    private SimpleStringProperty hsnNo;
    private SimpleFloatProperty gst;
    private SimpleStringProperty suppliers;
    private SimpleStringProperty highRisk;
    private SimpleStringProperty scheduledH1;

    public Products() {
    }

    public Products(SimpleStringProperty itemType, SimpleStringProperty name, SimpleStringProperty strength, SimpleStringProperty genericName, SimpleStringProperty packSize, SimpleStringProperty category, SimpleStringProperty manufacturer, SimpleStringProperty hsnNo, SimpleFloatProperty gst, SimpleStringProperty suppliers, SimpleStringProperty highRisk, SimpleStringProperty scheduledH1) {
        this.itemType = itemType;
        this.name = name;
        this.strength = strength;
        this.genericName = genericName;
        this.packSize = packSize;
        this.category = category;
        this.manufacturer = manufacturer;
        this.hsnNo = hsnNo;
        this.gst = gst;
        this.suppliers = suppliers;
        this.highRisk = highRisk;
        this.scheduledH1 = scheduledH1;
    }

    public String getItemType() {
        return itemType.get();
    }

    public SimpleStringProperty itemTypeProperty() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType.set(itemType);
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

    public String getStrength() {
        return strength.get();
    }

    public SimpleStringProperty strengthProperty() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength.set(strength);
    }

    public String getGenericName() {
        return genericName.get();
    }

    public SimpleStringProperty genericNameProperty() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName.set(genericName);
    }

    public String getPackSize() {
        return packSize.get();
    }

    public SimpleStringProperty packSizeProperty() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize.set(packSize);
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

    public String getManufacturer() {
        return manufacturer.get();
    }

    public SimpleStringProperty manufacturerProperty() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public String getHsnNo() {
        return hsnNo.get();
    }

    public SimpleStringProperty hsnNoProperty() {
        return hsnNo;
    }

    public void setHsnNo(String hsnNo) {
        this.hsnNo.set(hsnNo);
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

    public String getSuppliers() {
        return suppliers.get();
    }

    public SimpleStringProperty suppliersProperty() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers.set(suppliers);
    }

    public String getHighRisk() {
        return highRisk.get();
    }

    public SimpleStringProperty highRiskProperty() {
        return highRisk;
    }

    public void setHighRisk(String highRisk) {
        this.highRisk.set(highRisk);
    }

    public String getScheduledH1() {
        return scheduledH1.get();
    }

    public SimpleStringProperty scheduledH1Property() {
        return scheduledH1;
    }

    public void setScheduledH1(String scheduledH1) {
        this.scheduledH1.set(scheduledH1);
    }
}
