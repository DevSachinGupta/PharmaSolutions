package me.sachingupta.autos;

import me.sachingupta.aid.DataBase;

import java.sql.ResultSet;

public class SaleDataFetcher extends Thread {

    @Override
    public void run() {
        try {

            DataBase db = new DataBase();
            ResultSet rs =  db.selectTableData("select * from sale");

        }catch (Exception e){}
    }
}
