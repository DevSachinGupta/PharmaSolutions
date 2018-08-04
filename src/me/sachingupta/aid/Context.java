package me.sachingupta.aid;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by InventoSachin on 25-06-2017.
 */
public class Context {
    private final static Context instance = new Context();

    private SimpleStringProperty cat = new SimpleStringProperty();

    public static Context getInstance() {
        return instance;
    }

    public String getCat() {
        return cat.get();
    }

    public SimpleStringProperty catProperty() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat.set(cat);
    }
}
