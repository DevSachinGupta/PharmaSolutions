package sample;

import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sachin Gupta on 21-05-2017.
 */
public class DataBase  implements Runnable{


    private static SQLiteDataSource sqLiteDataSource;

    public DataBase(){
        try {
            DriverManager.registerDriver(new JDBC());
            sqLiteDataSource=new SQLiteDataSource();
            sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

    }
}
