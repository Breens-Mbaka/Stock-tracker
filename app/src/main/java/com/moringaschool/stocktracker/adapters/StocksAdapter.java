package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.MyViewHolder> {
    Context context;
    private List<Coin> cryptoList;
    public StocksAdapter(List<Coin> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public StocksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StocksAdapter.MyViewHolder holder, int position) {
        holder.mSymbol.setText(cryptoList.get(position).getSymbol());
        holder.mName.setText(cryptoList.get(position).getName());

        Double price = Double.parseDouble(cryptoList.get(position).getPrice());
        Double number = Math.round(price * 100.0) /100.0;
        holder.mCurrency.setText("$" + number.toString());


        Double change = Double.parseDouble(cryptoList.get(position).getChange());
        Double priceChange = Math.round(change * 100.0) /100.0;
        if(priceChange < 0) {
            holder.mCountry.setTextColor(Color.parseColor("#FF0000"));
        }
        else{
            holder.mCountry.setTextColor(Color.parseColor("#1B5E20"));
        }
        holder.mCountry.setText("$" + priceChange.toString());
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.coinImage) ImageView mImage;
        @BindView(R.id.textView3) TextView mSymbol;
        @BindView(R.id.textView4) TextView mName;
        @BindView(R.id.textView5) TextView mCurrency;
        @BindView(R.id.textView6) TextView mCountry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
