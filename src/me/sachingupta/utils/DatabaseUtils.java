package me.sachingupta.utils;

public class DatabaseUtils {
    private static DatabaseUtils db = null;

    public DatabaseUtils getInstance() {
        if(db == null) {
            return new DatabaseUtils();
        }
        return db;
    }
}
