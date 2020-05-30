package me.sachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

public class Vendor {
    private SimpleStringProperty vendorName;
    private SimpleStringProperty contactPerson;
    private SimpleStringProperty contactNo;
    private SimpleStringProperty telephoneNo;
    private SimpleStringProperty emailId;
    private SimpleStringProperty gstNo;
    private SimpleStringProperty tinNo;
    private SimpleStringProperty dlNo;
    private SimpleStringProperty companies;
    private SimpleStringProperty specialities;
    private SimpleStringProperty vendorAddressLine1;
    private SimpleStringProperty vendorAddressLine2;
    private SimpleStringProperty country;
    private SimpleStringProperty city;
    private SimpleStringProperty state;
    private SimpleStringProperty pincode;

    public Vendor() {
    }

    public Vendor(SimpleStringProperty vendorName, SimpleStringProperty contactPerson, SimpleStringProperty contactNo, SimpleStringProperty telephoneNo, SimpleStringProperty emailId, SimpleStringProperty gstNo, SimpleStringProperty tinNo, SimpleStringProperty dlNo, SimpleStringProperty companies, SimpleStringProperty specialities, SimpleStringProperty vendorAddressLine1, SimpleStringProperty vendorAddressLine2, SimpleStringProperty country, SimpleStringProperty city, SimpleStringProperty state, SimpleStringProperty pincode) {
        this.vendorName = vendorName;
        this.contactPerson = contactPerson;
        this.contactNo = contactNo;
        this.telephoneNo = telephoneNo;
        this.emailId = emailId;
        this.gstNo = gstNo;
        this.tinNo = tinNo;
        this.dlNo = dlNo;
        this.companies = companies;
        this.specialities = specialities;
        this.vendorAddressLine1 = vendorAddressLine1;
        this.vendorAddressLine2 = vendorAddressLine2;
        this.country = country;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getVendorName() {
        return vendorName.get();
    }

    public SimpleStringProperty vendorNameProperty() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName.set(vendorName);
    }

    public String getContactPerson() {
        return contactPerson.get();
    }

    public SimpleStringProperty contactPersonProperty() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson.set(contactPerson);
    }

    public String getContactNo() {
        return contactNo.get();
    }

    public SimpleStringProperty contactNoProperty() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo.set(contactNo);
    }

    public String getTelephoneNo() {
        return telephoneNo.get();
    }

    public SimpleStringProperty telephoneNoProperty() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo.set(telephoneNo);
    }

    public String getEmailId() {
        return emailId.get();
    }

    public SimpleStringProperty emailIdProperty() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId.set(emailId);
    }

    public String getGstNo() {
        return gstNo.get();
    }

    public SimpleStringProperty gstNoProperty() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo.set(gstNo);
    }

    public String getTinNo() {
        return tinNo.get();
    }

    public SimpleStringProperty tinNoProperty() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo.set(tinNo);
    }

    public String getDlNo() {
        return dlNo.get();
    }

    public SimpleStringProperty dlNoProperty() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo.set(dlNo);
    }

    public String getCompanies() {
        return companies.get();
    }

    public SimpleStringProperty companiesProperty() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies.set(companies);
    }

    public String getSpecialities() {
        return specialities.get();
    }

    public SimpleStringProperty specialitiesProperty() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities.set(specialities);
    }

    public String getVendorAddressLine1() {
        return vendorAddressLine1.get();
    }

    public SimpleStringProperty vendorAddressLine1Property() {
        return vendorAddressLine1;
    }

    public void setVendorAddressLine1(String vendorAddressLine1) {
        this.vendorAddressLine1.set(vendorAddressLine1);
    }

    public String getVendorAddressLine2() {
        return vendorAddressLine2.get();
    }

    public SimpleStringProperty vendorAddressLine2Property() {
        return vendorAddressLine2;
    }

    public void setVendorAddressLine2(String vendorAddressLine2) {
        this.vendorAddressLine2.set(vendorAddressLine2);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getPincode() {
        return pincode.get();
    }

    public SimpleStringProperty pincodeProperty() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode.set(pincode);
    }
}
