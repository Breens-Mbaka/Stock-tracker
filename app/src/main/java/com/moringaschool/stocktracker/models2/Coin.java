
package com.moringaschool.stocktracker.models2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("websiteUrl")
    @Expose
    private String websiteUrl;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("supply")
    @Expose
    private Supply supply;
    @SerializedName("24hVolume")
    @Expose
    private String _24hVolume;
    @SerializedName("marketCap")
    @Expose
    private String marketCap;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("btcPrice")
    @Expose
    private String btcPrice;
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("numberOfMarkets")
    @Expose
    private Integer numberOfMarkets;
    @SerializedName("numberOfExchanges")
    @Expose
    private Integer numberOfExchanges;
    @SerializedName("sparkline")
    @Expose
    private List<String> sparkline = null;
    @SerializedName("allTimeHigh")
    @Expose
    private AllTimeHigh allTimeHigh;
    @SerializedName("coinrankingUrl")
    @Expose
    private String coinrankingUrl;
    @SerializedName("tier")
    @Expose
    private String tier;


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
     * @param numberOfMarkets
     * @param change
     * @param description
     * @param btcPrice
     * @param uuid
     * @param supply
     * @param sparkline
     * @param _24hVolume
     * @param websiteUrl
     * @param allTimeHigh
     * @param coinrankingUrl
     * @param price
     * @param name
     * @param numberOfExchanges
     * @param rank
     * @param links
     * @param iconUrl
     */
    public Coin(String uuid, String symbol, String name, String description, String color, String iconUrl, String websiteUrl, List<Link> links, Supply supply, String _24hVolume, String marketCap, String price, String btcPrice, String change, Integer rank, Integer numberOfMarkets, Integer numberOfExchanges, List<String> sparkline, AllTimeHigh allTimeHigh, String coinrankingUrl,String tier) {
        super();
        this.uuid = uuid;
        this.symbol = symbol;
        this.name = name;
        this.description = description;
        this.color = color;
        this.iconUrl = iconUrl;
        this.websiteUrl = websiteUrl;
        this.links = links;
        this.supply = supply;
        this._24hVolume = _24hVolume;
        this.marketCap = marketCap;
        this.price = price;
        this.btcPrice = btcPrice;
        this.change = change;
        this.rank = rank;
        this.numberOfMarkets = numberOfMarkets;
        this.numberOfExchanges = numberOfExchanges;
        this.sparkline = sparkline;
        this.allTimeHigh = allTimeHigh;
        this.coinrankingUrl = coinrankingUrl;
        this.tier = tier;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public String get24hVolume() {
        return _24hVolume;
    }

    public void set24hVolume(String _24hVolume) {
        this._24hVolume = _24hVolume;
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

    public Integer getNumberOfMarkets() {
        return numberOfMarkets;
    }

    public void setNumberOfMarkets(Integer numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
    }

    public Integer getNumberOfExchanges() {
        return numberOfExchanges;
    }

    public void setNumberOfExchanges(Integer numberOfExchanges) {
        this.numberOfExchanges = numberOfExchanges;
    }

    public List<String> getSparkline() {
        return sparkline;
    }

    public void setSparkline(List<String> sparkline) {
        this.sparkline = sparkline;
    }

    public AllTimeHigh getAllTimeHigh() {
        return allTimeHigh;
    }

    public void setAllTimeHigh(AllTimeHigh allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public String getCoinrankingUrl() {
        return coinrankingUrl;
    }

    public void setCoinrankingUrl(String coinrankingUrl) {
        this.coinrankingUrl = coinrankingUrl;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

}
