
package com.moringaschool.stocktracker.models2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllTimeHigh {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AllTimeHigh() {
    }

    /**
     * 
     * @param price
     * @param timestamp
     */
    public AllTimeHigh(String price, Integer timestamp) {
        super();
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}
