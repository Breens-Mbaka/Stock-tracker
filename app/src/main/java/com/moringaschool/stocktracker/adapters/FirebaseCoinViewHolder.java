package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.ui.CryptoStats;
import com.moringaschool.stocktracker.utils.ItemTouchHelperViewHolder;

import org.parceler.Parcels;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COINS;

public class FirebaseCoinViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    View mView;
    Context mContext;
    public ImageView mReorderImage;


    public FirebaseCoinViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindCoins(Coin coin) {
        mReorderImage =  mView.findViewById(R.id.reorderImage);
        ImageView coinImage2 = mView.findViewById(R.id.coinImage2);
        TextView mName = mView.findViewById(R.id.name);
        TextView mSymbol = mView.findViewById(R.id.symbol);
        TextView mPrice = mView.findViewById(R.id.price2);
        TextView mChange = mView.findViewById(R.id.change2);

        GlideToVectorYou
                .init()
                .with(mContext)
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
                .load(Uri.parse(coin.getIconUrl()), coinImage2);
        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());

        double price = Double.parseDouble(coin.getPrice());
        double number = Math.round(price * 100.0) / 100.0;
        DecimalFormat df = new DecimalFormat("###,###.##");
        String roundedPrice = df.format(number);
        mPrice.setText("$" + roundedPrice);

        double change = Double.parseDouble(coin.getChange());
        double priceChange = Math.round(change * 100.0) / 100.0;
        if (priceChange < 0) {
            int newPriceChange = (int) Math.abs(priceChange);
            mChange.setTextColor(Color.parseColor("#FF0000"));
            mChange.setText("-$" + Double.toString(newPriceChange));
        } else {
            mChange.setTextColor(Color.parseColor("#00e676"));
            mChange.setText("+$" + Double.toString(priceChange));
        }
    }

    @Override
    public void onItemSelected() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear() {
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }
}
