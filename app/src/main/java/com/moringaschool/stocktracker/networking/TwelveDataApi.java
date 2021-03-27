package com.moringaschool.stocktracker.networking;

import com.moringaschool.stocktracker.models.Stocks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwelveDataApi {
    @GET("quote?symbol=tsla,aapl,amzn,msft,nio,nvda,mrna&apikey=5145b6ccdac740c28ec1787fa095cdc5")
    Call<Stocks> getStocks();
}
