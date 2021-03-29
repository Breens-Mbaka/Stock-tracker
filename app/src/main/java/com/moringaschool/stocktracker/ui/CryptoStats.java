package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoStats extends AppCompatActivity {
    @BindView(R.id.textView8) TextView mTextNames;
    @BindView(R.id.textView9) TextView mTextPrice;
    @BindView(R.id.textView13) TextView mHighestPrice;
    @BindView(R.id.textView15) TextView mMarketValue;
    @BindView(R.id.textView17) TextView mRanks;
    @BindView(R.id.textView19) TextView mTier;
    @BindView(R.id.textView21) TextView mVolumeTraded;
    @BindView(R.id.textView23) TextView mCirculation;
    @BindView(R.id.button2) Button mButton2;

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

                //converting string to double then rounding off the price
                double price = Double.parseDouble(response.body().getData().getCoin().getPrice());
                double number = Math.round(price * 100.0) /100.0;
                mTextPrice.setText("$" + Double.toString(number));

                double doubleHighestPrice = Double.parseDouble(response.body().getData().getCoin().getAllTimeHigh().getPrice());
                double highestPrice = Math.round(doubleHighestPrice * 100.0) /100.0;
                DecimalFormat priceDf = new DecimalFormat("###,###.##");
                String stringPrice = priceDf.format(highestPrice);
                mHighestPrice.setText("$" + stringPrice);

                Double doubleMarketCap = Double.parseDouble(response.body().getData().getCoin().getMarketCap());
                if(doubleMarketCap > 999999999999.0){
                    DecimalFormat df = new DecimalFormat("##.##");
                    String roundedMarketCap = df.format(doubleMarketCap/1000000000000.0);
                    mMarketValue.setText("$" + roundedMarketCap + "T");
                }
                else {
                    DecimalFormat df = new DecimalFormat("###,###");
                    String roundedMarketCap = df.format(doubleMarketCap);
                    mMarketValue.setText("$" + roundedMarketCap);
                }

                mRanks.setText(response.body().getData().getCoin().getRank().toString());

                mTier.setText(response.body().getData().getCoin().getTier());


                Double volumeTraded = Double.parseDouble(response.body().getData().getCoin().get24hVolume());
                DecimalFormat df = new DecimalFormat("###,###");
                String roundedVolume = df.format(volumeTraded);
                mVolumeTraded.setText("$" + roundedVolume);

                double circulation = Double.parseDouble(response.body().getData().getCoin().getSupply().getCirculating());
                DecimalFormat circulationDf = new DecimalFormat("###,###.##");
                String stringCirculation = circulationDf.format(circulation);
                mCirculation.setText("$" + stringCirculation);

                mButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(response.body().getData().getCoin().getCoinrankingUrl()));
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<CryptoData> call, Throwable t) {
                Log.e("ERROR","Message: " + t);
            }
        });
    }
}