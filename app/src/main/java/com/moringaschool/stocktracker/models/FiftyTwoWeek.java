
package com.moringaschool.stocktracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FiftyTwoWeek {

    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("low_change")
    @Expose
    private String lowChange;
    @SerializedName("high_change")
    @Expose
    private String highChange;
    @SerializedName("low_change_percent")
    @Expose
    private String lowChangePercent;
    @SerializedName("high_change_percent")
    @Expose
    private String highChangePercent;
    @SerializedName("range")
    @Expose
    private String range;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FiftyTwoWeek() {
    }

    /**
     * 
     * @param lowChangePercent
     * @param high
     * @param low
     * @param lowChange
     * @param highChange
     * @param highChangePercent
     * @param range
     */
    public FiftyTwoWeek(String low, String high, String lowChange, String highChange, String lowChangePercent, String highChangePercent, String range) {
        super();
        this.low = low;
        this.high = high;
        this.lowChange = lowChange;
        this.highChange = highChange;
        this.lowChangePercent = lowChangePercent;
        this.highChangePercent = highChangePercent;
        this.range = range;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLowChange() {
        return lowChange;
    }

    public void setLowChange(String lowChange) {
        this.lowChange = lowChange;
    }

    public String getHighChange() {
        return highChange;
    }

    public void setHighChange(String highChange) {
        this.highChange = highChange;
    }

    public String getLowChangePercent() {
        return lowChangePercent;
    }

    public void setLowChangePercent(String lowChangePercent) {
        this.lowChangePercent = lowChangePercent;
    }

    public String getHighChangePercent() {
        return highChangePercent;
    }

    public void setHighChangePercent(String highChangePercent) {
        this.highChangePercent = highChangePercent;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

}
