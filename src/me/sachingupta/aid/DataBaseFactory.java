package me.sachingupta.aid;

import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sachin Gupta on 21-05-2017.
 */
public class DataBaseFactory {

    private static DataBaseFactory dataBaseFactory = null;
    private Connection connection = null;
    private SQLiteDataSource sqLiteDataSource;

    private DataBaseFactory(){
        try {
            if(connection == null ) {
                makeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void makeConnection() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
        connection = sqLiteDataSource.getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataBaseFactory getInstance(){
        if(dataBaseFactory == null)
            dataBaseFactory = new DataBaseFactory();
        return dataBaseFactory;
    }

}
