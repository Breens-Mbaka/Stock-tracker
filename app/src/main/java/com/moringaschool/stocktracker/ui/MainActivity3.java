package com.moringaschool.stocktracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.stocktracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity3 extends AppCompatActivity {
    @BindView(R.id.listView2) ListView mListView2;
    @BindView(R.id.textView35) TextView mPortfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
    }
}