package me.sachingupta.dao;

import lombok.Data;

@Data
public class Products {
    private long id;
    private String itemType;
    private String name;
    private String strength;
    private String genericName;
    private String packSize;
    private String category;
    private String manufacturer;
    private String hsnNo;
    private float gst;
    private String suppliers;
    private String highRisk;
    private String scheduledH1;

}
