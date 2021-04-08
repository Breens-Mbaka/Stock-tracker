
package com.moringaschool.stocktracker.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Coin {

    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("marketCap")
    @Expose
    private String marketCap;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("btcPrice")
    @Expose
    private String btcPrice;
    @SerializedName("listedAt")
    @Expose
    private Integer listedAt;
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("sparkline")
    @Expose
    private List<String> sparkline = null;
    @SerializedName("coinrankingUrl")
    @Expose
    private String coinrankingUrl;
    @SerializedName("24hVolume")
    @Expose
    private String _24hVolume;
    private String pushId;
    /**
     * No args constructor for use in serialization
     * 
     */
    public Coin() {
    }

    /**
     * 
     * @param symbol
     * @param marketCap
     * @param color
     * @param change
     * @param btcPrice
     * @param listedAt
     * @param uuid
     * @param sparkline
     * @param _24hVolume
     * @param coinrankingUrl
     * @param price
     * @param name
     * @param rank
     * @param iconUrl
     */
    public Coin(String uuid, String symbol, String name, String color, String iconUrl, String marketCap, String price, String btcPrice, Integer listedAt, String change, Integer rank, List<String> sparkline, String coinrankingUrl, String _24hVolume) {
        super();
        this.uuid = uuid;
        this.symbol = symbol;
        this.name = name;
        this.color = color;
        this.iconUrl = iconUrl;
        this.marketCap = marketCap;
        this.price = price;
        this.btcPrice = btcPrice;
        this.listedAt = listedAt;
        this.change = change;
        this.rank = rank;
        this.sparkline = sparkline;
        this.coinrankingUrl = coinrankingUrl;
        this._24hVolume = _24hVolume;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(String btcPrice) {
        this.btcPrice = btcPrice;
    }

    public Integer getListedAt() {
        return listedAt;
    }

    public void setListedAt(Integer listedAt) {
        this.listedAt = listedAt;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<String> getSparkline() {
        return sparkline;
    }

    public void setSparkline(List<String> sparkline) {
        this.sparkline = sparkline;
    }

    public String getCoinrankingUrl() {
        return coinrankingUrl;
    }

    public void setCoinrankingUrl(String coinrankingUrl) {
        this.coinrankingUrl = coinrankingUrl;
    }

    public String get24hVolume() {
        return _24hVolume;
    }

    public void set24hVolume(String _24hVolume) {
        this._24hVolume = _24hVolume;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
