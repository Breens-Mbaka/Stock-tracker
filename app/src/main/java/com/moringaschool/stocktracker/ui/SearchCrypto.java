package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.stocktracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchCrypto extends AppCompatActivity {
    @BindView(R.id.listView2) ListView mListView2;
    @BindView(R.id.textView35) TextView mPortfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_crypto);
        ButterKnife.bind(this);
    }
}