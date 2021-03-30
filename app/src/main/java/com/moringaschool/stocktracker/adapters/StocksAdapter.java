package com.moringaschool.stocktracker.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestBuilder;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.ui.CryptoStats;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.MyViewHolder> {
    private Context mContext;
    private List<Coin> mCryptoList;
    private RequestBuilder<PictureDrawable> requestBuilder;
    public StocksAdapter(Context context,List<Coin> cryptoList) {
        mContext = context;
        mCryptoList = cryptoList;
    }

    @NonNull
    @Override
    public StocksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StocksAdapter.MyViewHolder holder, int position) {
        holder.mSymbol.setText(mCryptoList.get(position).getSymbol());
        holder.mName.setText(mCryptoList.get(position).getName());

        GlideToVectorYou
                .init()
                .with(mContext)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        Toast.makeText(mContext, "Load failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResourceReady() {
                        Toast.makeText(mContext, "Image ready", Toast.LENGTH_SHORT).show();
                    }
                })
                .load(Uri.parse(mCryptoList.get(position).getIconUrl()),holder.mImage);

        Double price = Double.parseDouble(mCryptoList.get(position).getPrice());
        Double number = Math.round(price * 100.0) /100.0;
        holder.mCurrency.setText("$" + number.toString());


        Double change = Double.parseDouble(mCryptoList.get(position).getChange());
        Double priceChange = Math.round(change * 100.0) /100.0;
        if(priceChange < 0) {
            holder.mCountry.setTextColor(Color.parseColor("#FF0000"));
        }
        else{
            holder.mCountry.setTextColor(Color.parseColor("#1B5E20"));
        }
        holder.mCountry.setText("$" + priceChange.toString());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CryptoStats.class);
                intent.putExtra("uuid", mCryptoList.get(position).getUuid());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCryptoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.coinImage) ImageView mImage;
        @BindView(R.id.textView3) TextView mSymbol;
        @BindView(R.id.textView4) TextView mName;
        @BindView(R.id.textView5) TextView mCurrency;
        @BindView(R.id.textView6) TextView mCountry;
        @BindView(R.id.listContent) RelativeLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
