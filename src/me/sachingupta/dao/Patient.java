package me.sachingupta.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sachin Gupta on 08-06-20new String(7.
 */
@Entity
public class Patient {
    @Id
    @Column(name = "patient_id")
    private String id;
    @Column(name = "patient_name")
    private String name;
    @Column(name = "patient_dob")
    private String dob;
    @Column(name = "patient_age")
    private String age;
    @Column(name = "patient_gender")
    private String gender;
    @Column
    private String doctor_name;
    @Column
    private String diagnosis;

    public Patient(String id, String name, String dob, String age, String gender, String doctor_name, String diagnosis) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.doctor_name = doctor_name;
        this.diagnosis = diagnosis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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
