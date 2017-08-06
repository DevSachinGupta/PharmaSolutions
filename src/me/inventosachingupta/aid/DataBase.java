package me.inventosachingupta.aid;

import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;

import java.sql.*;

/**
 * Created by Sachin Gupta on 21-05-2017.
 */
public class DataBase {

    private static Connection connection;
    private static SQLiteDataSource sqLiteDataSource;

    public DataBase(){
        try {
            DriverManager.registerDriver(new JDBC());
            sqLiteDataSource=new SQLiteDataSource();
            sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
            connection=sqLiteDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        //if(connection!=null)
        return connection;
    }

    public  ResultSet selectTableData(String sql) throws SQLException {
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery(sql);
        return rs;
    }

    public static int insertData(String sql){
        int res = -1;
        try {
            if (connection == null) {
                DriverManager.registerDriver(new JDBC());
                sqLiteDataSource=new SQLiteDataSource();
                sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
                connection=sqLiteDataSource.getConnection();
            }
            Statement st = connection.createStatement();
            res = st.executeUpdate(sql);
            connection.commit();
        }
        catch(Exception e){}
        return res;
    }

}
