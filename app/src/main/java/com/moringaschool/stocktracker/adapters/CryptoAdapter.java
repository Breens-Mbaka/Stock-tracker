package com.moringaschool.stocktracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moringaschool.stocktracker.R;

public class CryptoAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mSymbol;
    private String[] mNames;
    private String[] mPrice;
    private String[] mTrend;

    public CryptoAdapter(Context context, String[] symbol, String[] names, String[] price, String[] trend) {
        this.mContext = context;
        this.mSymbol = symbol;
        this.mNames = names;;
        this.mPrice = price;
        this.mTrend = trend;
    }

    @Override
    public int getCount() {
        return mNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.crypto_currencies, parent,false);

        TextView textSymbol = convertView.findViewById(R.id.textView31);
        TextView textName = convertView.findViewById(R.id.textView32);
        TextView textPrice = convertView.findViewById(R.id.textView33);
        TextView textTrend = convertView.findViewById(R.id.textView34);

        textSymbol.setText(mSymbol[position]);
        textName.setText(mNames[position]);
        textPrice.setText(mPrice[position]);
        textTrend.setText(mTrend[position]);
        return convertView;
    }
}
