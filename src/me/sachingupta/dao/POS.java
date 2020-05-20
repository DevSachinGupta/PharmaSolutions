package me.sachingupta.dao;

import javafx.collections.ObservableList;
import lombok.Data;

import java.util.Date;

@Data
public class POS {
    private int billId;
    private Date billDate;
    private String customerName;
    private String doctorName;
    private ObservableList<SoldItems> soldItems;
    private long discountPercentage;
    private long taxableAmount;
    private long gstAmount;
    private long totalAmount;
    private long discountAmount;
    private long netPayableAmount;
    private String paymentMode;

}
