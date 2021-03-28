package com.moringaschool.stocktracker.networking;

import com.moringaschool.stocktracker.models.MyCrypto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TwelveDataApi {
    @GET("coins?limit=15")
    Call<MyCrypto> getStocks();
}
