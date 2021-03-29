
package com.moringaschool.stocktracker.models2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Supply {

    @SerializedName("confirmed")
    @Expose
    private Boolean confirmed;
    @SerializedName("circulating")
    @Expose
    private String circulating;
    @SerializedName("total")
    @Expose
    private String total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Supply() {
    }

    /**
     * 
     * @param circulating
     * @param total
     * @param confirmed
     */
    public Supply(Boolean confirmed, String circulating, String total) {
        super();
        this.confirmed = confirmed;
        this.circulating = circulating;
        this.total = total;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getCirculating() {
        return circulating;
    }

    public void setCirculating(String circulating) {
        this.circulating = circulating;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
