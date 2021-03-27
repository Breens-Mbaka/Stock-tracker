package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.StocksAdapter;
import com.moringaschool.stocktracker.models.Stocks;
import com.moringaschool.stocktracker.networking.TwelveDataApi;
import com.moringaschool.stocktracker.networking.TwelveDataClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getStocksData();
    }

    public void getStocksData() {
        TwelveDataApi twelveDataApi = TwelveDataClient.getClient().create(TwelveDataApi.class);
        Call<Stocks> call = twelveDataApi.getStocks();

        call.enqueue(new Callback<Stocks>() {
            @Override
            public void onResponse(Call<Stocks> call, Response<Stocks> response) {
                Log.d("DEBUG","STOCK DATA: " + response.body());
            }

            @Override
            public void onFailure(Call<Stocks> call, Throwable t) {
                Log.e("ERROR","-> " + t);
            }
        });
    }
}