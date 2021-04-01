package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.models.MyCrypto;
import com.moringaschool.stocktracker.models2.CryptoData;
import com.moringaschool.stocktracker.networking.TwelveDataApi;
import com.moringaschool.stocktracker.networking.TwelveDataClient;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoStats extends AppCompatActivity {
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.imageView) ImageView mImageView;
    private List<Coin> coinList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crypto_stats);
        ButterKnife.bind(this);
        getData();
    }

    private void getData() {
        String coinID = getIntent().getStringExtra("uuid");
        String iconUrl = getIntent().getStringExtra("icon url");

        TwelveDataApi twelveDataApi = TwelveDataClient.getClient();
        Call<CryptoData> call = twelveDataApi.getCryptoStats(coinID);

        call.enqueue(new Callback<CryptoData>() {
            @Override
            public void onResponse(Call<CryptoData> call, Response<CryptoData> response) {
                GlideToVectorYou
                        .init()
                        .withListener(new GlideToVectorYouListener() {
                            @Override
                            public void onLoadFailed() {
                                Log.e("ERROR", "Failed loading");
                            }

                            @Override
                            public void onResourceReady() {
                                Log.d("READY", "Image loaded");
                            }
                        })
                        .load(Uri.parse(iconUrl),mImageView);

                mButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CryptoStats.this, "Redirecting...Please wait", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(response.body().getData().getCoin().getCoinrankingUrl()));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<CryptoData> call, Throwable t) {
                Log.e("ERROR", "Message: " + t);
            }
        });
    }
}