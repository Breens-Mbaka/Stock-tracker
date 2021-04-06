package com.moringaschool.stocktracker.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CryptoStats extends AppCompatActivity implements View.OnClickListener{
    private List<Coin> coinList;
    private Context mContext;
    @BindView(R.id.backButton) ImageView mBackButton;
    @BindView(R.id.cryptoName) TextView mName;
    @BindView(R.id.favoriteImageView) ImageView mStar;
    @BindView(R.id.price) TextView mPrice;
    @BindView(R.id.change) TextView mChange;
    private boolean notClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crypto_stats);
        ButterKnife.bind(this);
        mBackButton.setOnClickListener(this);
        mStar.setOnClickListener(this);
        getData();
    }

    @Override
    public void onClick(View v) {
        if(v == mBackButton) {
            Intent intent = new Intent(CryptoStats.this, MainActivity.class);
            startActivity(intent);
        }
       if(notClicked) {
           mStar.setImageResource(R.drawable.ic_star_yellow);
           notClicked = false;
       }
       else {
           mStar.setImageResource(R.drawable.ic_star);
           notClicked = true;
       }
    }

    public void getData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mName.setText(name);

        String price = intent.getStringExtra("price");
        mPrice.setText("$" + price);

        String change = intent.getStringExtra("change");
        Double intChange = Double.parseDouble(change);
        if(intChange < 0) {
            mChange.setTextColor(Color.parseColor("#FF0000"));
            mChange.setText(Double.toString(intChange) + "%");
        }
        else {
            mChange.setTextColor(Color.parseColor("#00e676"));
            mChange.setText("+" + change + "%");
        }
    }
}