
package com.moringaschool.stocktracker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stocks {

    @SerializedName("tsla")
    @Expose
    private Tsla tsla;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stocks() {
    }

    /**
     * 
     * @param tsla
     */
    public Stocks(Tsla tsla) {
        super();
        this.tsla = tsla;
    }

    public Tsla getTsla() {
        return tsla;
    }

    public void setTsla(Tsla tsla) {
        this.tsla = tsla;
    }

}
