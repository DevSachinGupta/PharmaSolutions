package me.sachingupta.dao;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Sachin Gupta on 08-06-20new SimpleStringProperty(7.
 */
public class Patient {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty dob;
    private SimpleStringProperty age;
    private SimpleStringProperty gender;
    private SimpleStringProperty doctor_name;
    private SimpleStringProperty diagnosis;

    public Patient(String id, String name, String dob, String age, String gender, String doctor_name, String diagnosis) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.dob = new SimpleStringProperty(dob);
        this.age = new SimpleStringProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.doctor_name = new SimpleStringProperty(doctor_name);
        this.diagnosis = new SimpleStringProperty(diagnosis);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDob() {
        return dob.get();
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getDoctor_name() {
        return doctor_name.get();
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name.set(doctor_name);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }


    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name=" + name +
                ", dob=" + dob +
                ", age=" + age +
                ", gender=" + gender +
                ", doctor_name=" + doctor_name +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
