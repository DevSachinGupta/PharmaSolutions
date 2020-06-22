package me.sachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sachin Gupta on 08-06-2017.
 */
@Entity
public class Employee {
    @Id
    @Column(name="emp_id")
    private final String id;
    @Column(name="emp_name")
    private final String name;
    @Column(name="emp_phone")
    private final String contact;
    @Column(name="emp_email")
    private final String email;
    @Column(name="emp_job_title")
    private final String job_title;
    @Column(name="emp_department")
    private final String department;
    @Column(name="emp_shift")
    private final String shift;
    @Column(name="emp_type")
    private final String type;
    @Column(name="emp_address")
    private final String address;
    @Column(name="emp_start_date")
    private final String start_date;
    @Column(name="emp_end_date")
    private final String end_date;
    @Column(name="password")
    private final String pass;
    @Column(name="emp_qualification")
    private final String empqual;
    @Column(name="filepath")
    private final String filepath;
    @Column(name="certificate_details")
    private final String certdetail;

    public Employee() {
        this("","","","","","","","","","","","","","","");
    }

    public Employee(String id, String name, String contact, String email, String job_title, String department, String shift, String type, String address, String start_date, String end_date, String pass, String empqual,String filepath,String certdetail) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.job_title = job_title;
        this.department = department;
        this.shift = shift;
        this.type = type;
        this.address = address;
        this.start_date = start_date;
        this.end_date = end_date;
        this.pass=pass;
        this.empqual=empqual;
        this.filepath=filepath;
        this.certdetail=certdetail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getDepartment() {
        return department;
    }

    public String getShift() {
        return shift;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getPass() {
        return pass;
    }

    public String getEmpqual() {
        return empqual;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getCertdetail() {
        return certdetail;
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
