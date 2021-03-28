package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.MyCrypto;
import com.moringaschool.stocktracker.models2.CryptoData;
import com.moringaschool.stocktracker.networking.TwelveDataApi;
import com.moringaschool.stocktracker.networking.TwelveDataClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoStats extends AppCompatActivity {
    @BindView(R.id.textView8) TextView mTextNames;
    @BindView(R.id.textView9) TextView mTextPrice;
    @BindView(R.id.description) TextView mDescription;

    @BindView(R.id.button) Button mButton;
    @BindView(R.id.button2) Button mButton2;
    @BindView(R.id.editTextTextPersonName) EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crypto_stats);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        String coinID = getIntent().getStringExtra("uuid");

        TwelveDataApi twelveDataApi = TwelveDataClient.getClient();
        Call<CryptoData> call = twelveDataApi.getCryptoStats(coinID);

        call.enqueue(new Callback<CryptoData>() {
            @Override
            public void onResponse(Call<CryptoData> call, Response<CryptoData> response) {
                mTextNames.setText(response.body().getData().getCoin().getName());
                mTextPrice.setText(response.body().getData().getCoin().getPrice());
                mDescription.setText(response.body().getData().getCoin().getDescription());
            }

            @Override
            public void onFailure(Call<CryptoData> call, Throwable t) {
                Log.e("ERROR","Message: " + t);
            }
        });
    }
}