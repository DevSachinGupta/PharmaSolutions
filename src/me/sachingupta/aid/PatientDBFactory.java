package me.sachingupta.aid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import me.sachingupta.dao.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDBFactory {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PatientDBFactory() {
    }

    public Connection getConnection(){
        return DataBaseFactory.getInstance().getConnection();
    }

    public void add(Patient patient){
        try{

        }catch (Exception e){

        }
    }

    public void update(Patient patient){
        try{

        }catch (Exception e){

        }
    }

    public void delete(Patient patient){
        try{

        }catch (Exception e){

        }
    }

    public Patient find(Patient patient){
        try{

        }catch (Exception e){

        }
        return patient;
    }
    public ObservableList<Patient> getAll(){
        ObservableList<Patient> patients = FXCollections.observableArrayList();




        return patients;
    }
}
