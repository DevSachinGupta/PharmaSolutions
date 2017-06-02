package sample;

import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        return connection;
    }


}
