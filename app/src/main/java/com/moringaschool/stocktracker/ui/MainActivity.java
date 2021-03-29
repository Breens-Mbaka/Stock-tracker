package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.StocksAdapter;
import com.moringaschool.stocktracker.models.MyCrypto;
import com.moringaschool.stocktracker.networking.TwelveDataApi;
import com.moringaschool.stocktracker.networking.TwelveDataClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private StocksAdapter stocksAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getStocksData();
    }

    public void getStocksData() {
        TwelveDataApi twelveDataApi = TwelveDataClient.getClient();
        Call<MyCrypto> call = twelveDataApi.getStocks();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        call.enqueue(new Callback<MyCrypto>() {
            @Override
            public void onResponse(Call<MyCrypto> call, Response<MyCrypto> response) {
                Log.d("DEBUG","RESPONSE: " + response.body().getData().getCoins());
                stocksAdapter = new StocksAdapter(MainActivity.this,response.body().getData().getCoins());
                mRecyclerView.setAdapter(stocksAdapter);
            }

            @Override
            public void onFailure(Call<MyCrypto> call, Throwable t) {
                Log.e("ERROR", "ERROR: " + t);
            }
        });
    }
}