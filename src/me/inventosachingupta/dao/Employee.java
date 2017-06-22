package me.inventosachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
public class Employee {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty email;
    private final SimpleStringProperty job_title;
    private final SimpleStringProperty department;
    private final SimpleStringProperty shift;
    private final SimpleStringProperty type;
    private final SimpleStringProperty address;
    private final SimpleStringProperty start_date;
    private final SimpleStringProperty end_date;

    public Employee() {
        this("","","","","","","","","","","");
    }

    public Employee(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k){
        id=new SimpleStringProperty(a);
        name=new SimpleStringProperty(b);
        contact=new SimpleStringProperty(c);
        email=new SimpleStringProperty(d);
        job_title=new SimpleStringProperty(e);
        department=new SimpleStringProperty(f);
        shift=new SimpleStringProperty(g);
        type=new SimpleStringProperty(h);
        address=new SimpleStringProperty(i);
        start_date=new SimpleStringProperty(j);
        end_date=new SimpleStringProperty(k);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getJob_title() {
        return job_title.get();
    }

    public void setJob_title(String job_title) {
        this.job_title.set(job_title);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getShift() {
        return shift.get();
    }

    public void setShift(String shift) {
        this.shift.set(shift);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getStart_date() {
        return start_date.get();
    }

    public void setStart_date(String start_date) {
        this.start_date.set(start_date);
    }

    public String getEnd_date() {
        return end_date.get();
    }

    public void setEnd_date(String end_date) {
        this.end_date.set(end_date);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", contact=" + contact +
                ", email=" + email +
                ", job_title=" + job_title +
                ", department=" + department +
                ", shift=" + shift +
                ", type=" + type +
                ", address=" + address +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
