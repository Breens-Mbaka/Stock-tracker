package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestBuilder;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.models.Coin;
import com.moringaschool.stocktracker.ui.CryptoStats;

import java.text.DecimalFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.MyViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    private Context mContext;
    private List<Coin> mCryptoList;
    private RequestBuilder<PictureDrawable> requestBuilder;


    public StocksAdapter(Context context, List<Coin> cryptoList) {
        mContext = context;
        mCryptoList = cryptoList;
    }

    @NonNull
    @Override
    public StocksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_LIST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_item, parent, false);
            return new MyViewHolder(view, viewType);
        } else if (viewType == TYPE_HEAD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new MyViewHolder(view, viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StocksAdapter.MyViewHolder holder, int position) {
        if (holder.view_type == TYPE_LIST) {

            Coin crypto = mCryptoList.get(position-1);

            holder.mSymbol.setText(crypto.getSymbol());
            holder.mName.setText(crypto.getName());

            //loading svg icon images using Glide
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
                    .load(Uri.parse(crypto.getIconUrl()), holder.mImage);

            double price = Double.parseDouble(crypto.getPrice());
            double number = Math.round(price * 100.0) / 100.0;
            DecimalFormat df = new DecimalFormat("###,###.##");
            String roundedPrice = df.format(number);
            holder.mPrice.setText("$" + roundedPrice);


            double change = Double.parseDouble(crypto.getChange());
            double priceChange = Math.round(change * 100.0) / 100.0;
            if (priceChange < 0) {
                int newPriceChange = (int) Math.abs(priceChange);
                holder.mChange.setTextColor(Color.parseColor("#FF0000"));
                holder.mChange.setText("-$" + Double.toString(newPriceChange));
            } else {
                holder.mChange.setTextColor(Color.parseColor("#00e676"));
                holder.mChange.setText("+$" + Double.toString(priceChange));
            }

            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CryptoStats.class);
                    intent.putExtra("change", Double.toString(priceChange));
                    intent.putExtra("name", crypto.getName());
                    intent.putExtra("price", roundedPrice);
                    mContext.startActivity(intent);
                }
            });

        } else if (holder.view_type == TYPE_HEAD) {
            //holder.mGlobal1.setText("1.8T");
            //holder.mVolume.setText("191B");
            //holder.mTotalCoins.setText("7236");
        }


    }

    @Override
    public int getItemCount() {
        return mCryptoList.size() + 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        int view_type;

        CircleImageView mImage;
        TextView mSymbol;
        TextView mName;
        TextView mPrice;
        TextView mChange;
        RelativeLayout parentLayout;

        //header
        ImageView mMenu;
        TextView header2;

        public MyViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if (viewType == TYPE_LIST) {
                mImage = itemView.findViewById(R.id.coinImage);
                mSymbol = itemView.findViewById(R.id.textView3);
                mName = itemView.findViewById(R.id.textView4);
                mPrice = itemView.findViewById(R.id.textView5);
                mChange = itemView.findViewById(R.id.textView6);
                parentLayout = itemView.findViewById(R.id.listContent);
                view_type = 1;
            } else if (viewType == TYPE_HEAD) {
                header2 = itemView.findViewById(R.id.textView8);

                view_type = 0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_LIST;
        }
    }
}
