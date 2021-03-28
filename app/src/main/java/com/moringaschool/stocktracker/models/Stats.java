
package com.moringaschool.stocktracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalMarkets")
    @Expose
    private Integer totalMarkets;
    @SerializedName("totalExchanges")
    @Expose
    private Integer totalExchanges;
    @SerializedName("totalMarketCap")
    @Expose
    private String totalMarketCap;
    @SerializedName("total24hVolume")
    @Expose
    private String total24hVolume;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stats() {
    }

    /**
     * 
     * @param total
     * @param totalExchanges
     * @param totalMarkets
     * @param totalMarketCap
     * @param total24hVolume
     */
    public Stats(Integer total, Integer totalMarkets, Integer totalExchanges, String totalMarketCap, String total24hVolume) {
        super();
        this.total = total;
        this.totalMarkets = totalMarkets;
        this.totalExchanges = totalExchanges;
        this.totalMarketCap = totalMarketCap;
        this.total24hVolume = total24hVolume;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalMarkets() {
        return totalMarkets;
    }

    public void setTotalMarkets(Integer totalMarkets) {
        this.totalMarkets = totalMarkets;
    }

    public Integer getTotalExchanges() {
        return totalExchanges;
    }

    public void setTotalExchanges(Integer totalExchanges) {
        this.totalExchanges = totalExchanges;
    }

    public String getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(String totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public String getTotal24hVolume() {
        return total24hVolume;
    }

    public void setTotal24hVolume(String total24hVolume) {
        this.total24hVolume = total24hVolume;
    }

}
