package com.moringaschool.stocktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StocksArrayAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mNames;
    private String[] mSymbol;
    private String[] mPrice;
    private String[] mTrend;

    public StocksArrayAdapter(Context context, String[] names, String[] symbol, String[] price, String[] trend) {
        this.mContext = context;
        this.mNames = names;
        this.mSymbol = symbol;
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listView;

        if (convertView == null) {
            listView = inflater.inflate(R.layout.stock_item, null);

            TextView textName = listView.findViewById(R.id.textView3);
            TextView textSymbol = listView.findViewById(R.id.textView4);
            TextView textPrice = listView.findViewById(R.id.textView5);
            TextView textTrend = listView.findViewById(R.id.textView6);

            textName.setText(mNames[position]);
            textSymbol.setText(mSymbol[position]);
            textPrice.setText(mPrice[position]);
            textTrend.setText(mTrend[position]);
        } else {
            listView = (View) convertView;
        }
        return listView;
    }
}

