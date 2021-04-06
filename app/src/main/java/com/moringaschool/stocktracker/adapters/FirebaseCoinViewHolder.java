package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.ui.CryptoStats;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.moringaschool.stocktracker.Constants.FIREBASE_CHILD_COINS;

public class FirebaseCoinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    @BindView(R.id.coinImage) ImageView coinImage;
    @BindView(R.id.textView4) TextView mName;
    @BindView(R.id.textView3) TextView mSymbol;
    @BindView(R.id.textView5) TextView mPrice;
    @BindView(R.id.textView6) TextView mChange;

    public FirebaseCoinViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        ButterKnife.bind(this,mView);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCoins(Coin coin) {
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
                .load(Uri.parse(coin.getIconUrl()), coinImage);
        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mPrice.setText(coin.getPrice());
        mChange.setText(coin.getChange());
    }

    @Override
    public void onClick(View v) {
        final ArrayList<Coin> coins = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(FIREBASE_CHILD_COINS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    coins.add(snapshot.getValue(Coin.class));
                }
                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, CryptoStats.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("coins", Parcels.wrap(coins));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
