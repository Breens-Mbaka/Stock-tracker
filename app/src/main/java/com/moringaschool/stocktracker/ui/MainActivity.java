package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.moringaschool.stocktracker.R;
import com.moringaschool.stocktracker.adapters.StocksAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //list of information about a stock that will be displayed
        String[] symbols = {"TSLA", "AAPL", "AMZN", "MSFT", "NIO", "NVDA", "MRNA", "NKLA", "FB", "AMD", "ZOOM", "INTU", "COST", "TMUS", "PAPXX", "ABNB", "AMGN", "NFLX", "PEP", "SBUX", "CMSK"};
        String[] names = {"Tesla", "Apple Inc", "Amazon", "Microsoft", "Nio Limited", "Nvidia", "Moderna Inc", "Nikola", "Facebook", "Advanced Micro Devices", "Zoom", "Intuit", "Costco", "T-Mobile US", "PayPal", "Airbnb", "Amgen", "Netflix", "PepsiCo Inc", "Starbucks", "Comcast"};
        String[] stockPrice = {"$244.95", "$96.76", "$66.17", "$336.36", "$120.62", "$257.64", "$296.73", "$170.51", "$274.59", "$317.92", "$362.58", "$411.27", "$355.56", "$286.61", "$241.58", "$304.19", "$192.07", "$55.39", "$146.91", "$454.59", "$297.15"};
        String[] trend = {"$-2.38", "$-13.07", "$-19.62", "$-4.22", "$-15.37", "$-7.16", "$-16.27", "$-11.57", "$-16.60", "$-0.89", "$-4.08", "$-3.96", "$-10.79", "$-6.34", "$-10.44", "$-15.66", "$-18.67", "$-8.07", "$-1.88", "$-1.85", "$-15.80"};

        mListView.setAdapter( new StocksAdapter(this, symbols,names,stockPrice,trend));

        //Attached a click listener to here for clicks of individual views that are clicked
             mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     String nameClickedValue = names[position];
                     String stockPriceClickedValue = stockPrice[position];

                     Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                     intent.putExtra("name",nameClickedValue);
                     intent.putExtra("stock",stockPriceClickedValue);
                     startActivity(intent);
                 }
             });
    }
}