package com.moringaschool.stocktracker.networking;

import com.moringaschool.stocktracker.models.MyCrypto;
import com.moringaschool.stocktracker.models2.CryptoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TwelveDataApi {
    @GET("coins?limit=30")
    Call<MyCrypto> getStocks();

    @GET("coin/{coinId}")
    Call<CryptoData> getCryptoStats(@Path("coinId") String id);
}
