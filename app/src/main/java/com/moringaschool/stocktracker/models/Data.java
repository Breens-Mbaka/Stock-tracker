
package com.moringaschool.stocktracker.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Data {

    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("coins")
    @Expose
    private List<Coin> coins = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param stats
     * @param coins
     */
    public Data(Stats stats, List<Coin> coins) {
        super();
        this.stats = stats;
        this.coins = coins;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

}
