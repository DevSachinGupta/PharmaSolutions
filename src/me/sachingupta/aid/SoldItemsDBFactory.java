package me.sachingupta.aid;

import me.sachingupta.dao.SoldItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SoldItemsDBFactory {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;



    public void add(SoldItem s){

        String query = "insert into SoldItems values('"+s.getInvoiceno()+",'"+s.getIcode()+",'"+s.getIname()+",'"+s.getBatchno()+",'"+s.getEdate()+",'"+s.getFormulation()+",'"+s.getQuant()+",'"+s.getAmt()+",'"+s.getMrp()+"')";
    }
}
